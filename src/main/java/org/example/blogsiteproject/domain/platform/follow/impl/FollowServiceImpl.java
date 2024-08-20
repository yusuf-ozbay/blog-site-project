package org.example.blogsiteproject.domain.platform.follow.impl;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.auth.user.impl.UserServiceImpl;
import org.example.blogsiteproject.domain.platform.follow.api.FollowDto;
import org.example.blogsiteproject.domain.platform.follow.api.FollowService;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository repository;
    private final UserServiceImpl userService;

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<FollowDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }



    @Override
    public FollowDto getById(String id) {
        Follow follow = repository.findById(id).orElseThrow();

        UserDto followerDto = userService.getById(follow.getFollowerId());
        UserDto userDto = userService.getById(follow.getUserId());

        return FollowMapper.toDto(follow, followerDto, userDto);
    }

    @Override
    public FollowDto save(FollowDto dto) {
        UserDto followerDto = userService.getById(dto.getFollower().getId());
        UserDto userDto = userService.getById(dto.getUser().getId());

        return FollowMapper.toDto(repository.save(FollowMapper.toEntity(new Follow(), dto)), followerDto, userDto);
    }

    private Page<FollowDto> PageToDto(Page<Follow> follows) {
        List<String> followerIds = follows.stream().map(Follow::getFollowerId).toList();
        List<String> userIds = follows.stream().map(Follow::getUserId).toList();

        List<UserDto> followerDtoList = userService.getByIds(followerIds);
        List<UserDto> userDtoList = userService.getByIds(userIds);

        return PageUtil.pageToDto(follows, (follow -> {
            UserDto followerDto = followerDtoList.stream().filter((follower -> follower.getId().equals(follow.getFollowerId()))).findFirst().orElseThrow();
            UserDto userDto = userDtoList.stream().filter((user -> user.getId().equals(follow.getUserId()))).findFirst().orElseThrow();

            return FollowMapper.toDto(follow , followerDto, userDto);
        }));

    }
}

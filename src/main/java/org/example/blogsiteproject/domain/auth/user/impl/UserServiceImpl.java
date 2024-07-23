package org.example.blogsiteproject.domain.auth.user.impl;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.auth.user.api.UserService;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto dto) {
        return UserMapper.toDto(userRepository.save(UserMapper.toEntity(new User(), dto)));
    }

    @Override
    public UserDto getById(String id) {
        return UserMapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return PageUtil.pageToDto(userRepository.findAll(pageable), UserMapper::toDto);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto update(String id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user = UserMapper.toEntity(user, dto);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getByIds(List<String> userIds) {
        return userRepository.findAllById(userIds).stream().map(UserMapper::toDto).toList();
    }
}



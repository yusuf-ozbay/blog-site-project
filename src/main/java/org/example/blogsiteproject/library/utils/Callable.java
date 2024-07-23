package org.example.blogsiteproject.library.utils;
@FunctionalInterface
public interface Callable<T,R> {
    T call(R r);
}

package org.book.chap03.test;

public interface TriFunction<T, U, K, R> {
    R apply(T t, U u, K k);
}

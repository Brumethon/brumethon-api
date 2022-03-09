package com.brumethon.kernel;

public interface Validator<T> {
    void validate(T obj);
}

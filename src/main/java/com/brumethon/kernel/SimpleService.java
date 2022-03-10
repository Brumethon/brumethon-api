package com.brumethon.kernel;

import com.brumethon.kernel.exception.SimpleServiceException;

import java.util.List;

public abstract class SimpleService<R extends Repository<V, K> , V extends Entity<K>, K > {

    protected final R repository;
    protected final Validator<V> validator;

    public SimpleService(R repository, Validator<V> validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public V get(K key) {
        return repository.get(key).orElseThrow(() -> getExceptionWhenObjectNotFound(key));
    }

    public void add(V value) {
        validator.validate(value);

        if (repository.get(value.getID()).isPresent()) {
            throw getExceptionWhenObjectAlreadyPresent(value.getID());
        }

        repository.add(value);
    }

    public void update(V value) {
        if( !repository.update(value)){
            throw getExceptionWhenObjectNotFound(value.getID());
        }
    }

    public void remove(K key) {
        if (!repository.remove(key)) {
            throw getExceptionWhenObjectNotFound(key);
        }
    }

    public List<V> getAll() {
        return repository.getAll();
    }

    public abstract SimpleServiceException getExceptionWhenObjectNotFound(K key);

    public abstract SimpleServiceException getExceptionWhenObjectAlreadyPresent(K key);
}

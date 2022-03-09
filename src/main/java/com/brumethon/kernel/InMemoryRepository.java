package com.brumethon.kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class InMemoryRepository<K, V extends Entity<K>> implements Repository<K, V>{

    private List<V> list;

    protected InMemoryRepository(List<V> list) {
        this.list = list;
    }

    protected InMemoryRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public Optional<V> get(K key) {
        return list.stream()
                .filter(item -> item.getID().equals(key))
                .findFirst();
    }

    @Override
    public void add(V value) {
        list.add(value);
    }

    @Override
    public boolean update(V value) {
        if (list.stream().filter(it -> it.getID().equals(value.getID())).findFirst().isEmpty()) {
            return false;
        }
        list = list.stream()
                .filter(it -> !it.getID().equals(value.getID()))
                .collect(Collectors.toList());
        list.add(value);
        return true;
    }

    @Override
    public boolean remove(K key) {
        return list.removeIf(v -> v.getID().equals(key));
    }

    @Override
    public List<V> getAll() {
        return list;
    }
}

package com.brumethon.kernel;

import java.util.List;
import java.util.Optional;

public interface Repository <V extends Entity<K>, K>{
    Optional<V> get(K key);
    void add(V value);
    boolean update(V value);
    boolean remove(K value);
    List<V> getAll();
}

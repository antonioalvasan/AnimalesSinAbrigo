package org.is2.asa.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void add(T t);

    void update(T t);

    void delete(T t);
}
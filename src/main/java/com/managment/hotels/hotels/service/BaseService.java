package com.managment.hotels.hotels.service;

import java.util.List;

public interface BaseService<E, P> {
    List<E> findAll();

    E findBy(P primaryKey);

    void save(E entity);

    void delete(E entity);

    E update(E entity);
}

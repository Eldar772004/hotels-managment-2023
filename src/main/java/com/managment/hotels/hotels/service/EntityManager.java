package com.managment.hotels.hotels.service;

import com.managment.hotels.hotels.user.User;
import jdk.internal.event.Event;

public interface EntityManager {
    Event getTransaction();

    Query createNamedQuery(String s);

    void persist();

    User merge(Object user);

    void remove(Object user);

    boolean contains(Object user);
}

package com.managment.hotels.hotels.service;

import com.managment.hotels.hotels.user.User;

import java.util.List;

public class PrivilegeService implements PrivilegeServiceLocal {
    private Object persistenceUnitName;

    @Override
    public List<User> findAll() {
        EntityManager entityManager = getentityManager();
        Query query = entityManager.createNamedQuery("Privilege.findAll");
        return query.getResultList();

}

    private EntityManager getentityManager() {
        EntityManagerFactory entityManagerFactory = null;
        return (EntityManager) entityManagerFactory.createEntityManager();

    }
}

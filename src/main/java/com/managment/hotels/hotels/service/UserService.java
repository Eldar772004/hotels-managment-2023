package com.managment.hotels.hotels.service;

import com.managment.hotels.hotels.constants.Constants;
import com.managment.hotels.hotels.user.User;

import java.util.List;
import java.util.Objects;

public class UserService implements UserServiceLocal {
    private Object resultList;
    private Throwable exception;
    private Object Persistence;
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("User.findAll");
        entityManager.getTransaction().commit();
        return query.getResultList();

}

    @Override
    public User findBy(Integer primaryKey) {
        return null;
    }

    @Override
    public void save(User entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist();
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(User entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Object user = null;
        if(!entityManager.contains(user)){
            user = entityManager.merge(user);
        }
        entityManager.remove(user);
        //entityManager.remove(entityManager.contains(user) ? user: entityManager.merge(user));
        entityManager.getTransaction().commit();
    }

    @Override
    public User update(User entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        User user = null; user = entityManager.merge(user);
        entityManager.getTransaction().commit();
        return user;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory persistence = null;
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) persistence.createEntityManager();
        return entityManagerFactory.createEntityManager();



    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User Login(String usernameInput, String passwordInput) {
        return null;
    }

    @Override
    public List<User> findall() {
        return null;
    }
}

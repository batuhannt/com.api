package com.api_and_hibernate.com.api.dataAccess;

import com.api_and_hibernate.com.api.dtos.ApiResponseDataBaseEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


public class ApiResponseDatabaseDao {

    private EntityManager entityManager;

    @Autowired
    public ApiResponseDatabaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(ApiResponseDataBaseEntity entity){
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(int id){
        Session session=entityManager.unwrap(Session.class);
        ApiResponseDataBaseEntity entityToDelete= getById(id);
        System.out.println(entityToDelete.getId());
        session.delete(entityToDelete);
    }

    public ApiResponseDataBaseEntity getById(int id){
        Session session=entityManager.unwrap(Session.class);
        ApiResponseDataBaseEntity entity=session.get(ApiResponseDataBaseEntity.class, id);
        return entity;
    }
}

package com.example.hw_18082023_soap.soap.repository;

import com.example.hw_18082023_soap.soap.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Student findStudent(String name) {
        return entityManager.createQuery("select s from Student s where s.name =: name", Student.class).
                setParameter("name", name).getSingleResult();
    }
}

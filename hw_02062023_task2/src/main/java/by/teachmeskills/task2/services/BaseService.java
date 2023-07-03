package by.teachmeskills.task2.services;

import by.teachmeskills.task2.domain.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    T createService(T entity);

    List<T> readService();

    T updateService(T entity);

    void deleteService(int id);
}

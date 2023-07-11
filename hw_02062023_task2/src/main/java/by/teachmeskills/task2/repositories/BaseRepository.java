package by.teachmeskills.task2.repositories;

import by.teachmeskills.task2.domain.BaseEntity;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    T create(T entity);

    List<T> read();

    T update(T entity);

    void delete(int id);
}

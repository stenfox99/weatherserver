package by.bsuir.weather.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {

    boolean add(T object);
    boolean update(T object, Long id);
    boolean delete(Long id);

    Optional<T> getObjectById(Long id);
    List<T> getObjects();
}

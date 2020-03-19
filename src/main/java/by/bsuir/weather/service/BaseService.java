package by.bsuir.weather.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    boolean add(T object);
    T update(T object, Long id);
    boolean delete(Long id);

    Optional<T> getObjectById(Long id);
    List<T> getObjects();
}

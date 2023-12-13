package dev.skyherobrine.giuaky_t4_t1315.services;

import java.util.List;
import java.util.Optional;

public interface IServices<T>{
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    Optional<T> findById(String id);
    List<T> findAll();
}

package dev.skyherobrine.giuaky_t4_t1315.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepositories<T>{
    boolean insert(T t);
    boolean update(T t);
    boolean delete(String id);
    Optional<T> findById(String id);
    List<T> findAll();
}

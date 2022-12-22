package cz.cvut.fit.tjv.climbers2.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CrudRepository <T, ID>{
    T save(T entity);
    Optional<T> findByID(ID id);
    boolean existsById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}

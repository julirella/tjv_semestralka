package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.dao.CrudRepository;
import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;

import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class AbstractCrudService<E extends DomainEntity<K>, K> {

    protected final CrudRepository<E, K> repository;

    protected AbstractCrudService(CrudRepository<E, K> repository) {
        this.repository = repository;
    }

    public E create(E entity)throws EntityExistsException {
        K id = entity.getId();
        if(id != null && repository.existsById(id))throw new EntityExistsException(entity.getId().toString());
        return repository.save(entity);
    }

    public Optional<E> readById(K id){
        return repository.findByID(id);
    }

    public Iterable<E> readAll() {
        return repository.findAll();
    }

    public E update(E entity)throws EntityNotFoundException { //find better exception
        if(!repository.existsById(entity.getId()))throw new EntityNotFoundException(entity.getId().toString());
        return repository.save(entity);
    }

    public void deleteById(K id) {
        repository.deleteById(id);
    }
}

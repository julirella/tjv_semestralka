package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

//E - entity type
//K - object primary key type
public abstract class AbstractCrudService<E extends DomainEntity<K>, K> {

    protected final JpaRepository<E, K> repository;

    public AbstractCrudService(JpaRepository<E, K> repository) {
        this.repository = repository;
    }

    public E create(E entity)throws BadRequestException {
        K id = entity.getId();
        if(id != null && repository.existsById(id))throw new BadRequestException(entity.getClass().getSimpleName() + " with id " + entity.getId().toString() + " already exists.");
        return repository.save(entity);
    }

    public E readById(K id){
        Optional<E> entity = repository.findById(id);
        if(entity.isEmpty()) throw new BadRequestException("Requested entity with id " + id.toString() + " doesn't exist.");
        return entity.get();
    }

    public Iterable<E> readAll() {
        return repository.findAll();
    }

    public E update(E entity)throws BadRequestException {
        if(!repository.existsById(entity.getId()))throw new BadRequestException(entity.getClass().getSimpleName() + " with id " + entity.getId() + " doesn't exist.");
        return repository.save(entity);
    }

    public void deleteById(K id) {
        if(!repository.existsById(id)) throw new BadRequestException("Requested entity with id " + id.toString() + " doesn't exist.");
        repository.deleteById(id);
    }
}

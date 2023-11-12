package cz.cvut.fit.tjv.climbers2.business;

import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractCrudService<Entity extends DomainEntity<ID>, ID> {

    protected final JpaRepository<Entity, ID> repository;

    public AbstractCrudService(JpaRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    public Entity create(Entity entity)throws BadRequestException {
        ID id = entity.getId();
        if(id != null && repository.existsById(id))throw new BadRequestException(entity.getClass().getSimpleName() + " with id " + entity.getId().toString() + " already exists.");
        return repository.save(entity);
    }

    public Entity readById(ID id){
        Optional<Entity> entity = repository.findById(id);
        if(entity.isEmpty()) throw new IdDoesNotExistException("Requested entity with id " + id.toString() + " doesn't exist.");
        return entity.get();
    }

    public Iterable<Entity> readAll() {
        return repository.findAll();
    }

    public Entity update(Entity entity)throws BadRequestException {
        if(!repository.existsById(entity.getId()))throw new IdDoesNotExistException(entity.getClass().getSimpleName() + " with id " + entity.getId() + " doesn't exist.");
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        if(!repository.existsById(id)) throw new IdDoesNotExistException("Requested entity with id " + id.toString() + " doesn't exist.");
        repository.deleteById(id);
    }
}

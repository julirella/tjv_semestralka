package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.AbstractCrudService;
import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;
import org.springframework.web.bind.annotation.*;

//D - dto type??
public abstract class AbstractCrudController<Entity extends DomainEntity<ID>, D, ID> {

    protected AbstractCrudService<Entity, ID> service;
//    protected Function<E, D> entityToDtoConverter;
//    protected Function<D, E> dtoToEntityConverter;

    public AbstractCrudController(AbstractCrudService<Entity, ID> service/*, Function<E, D> entityToDtoConverter, Function<D, E> dtoToEntityConverter*/) {
        this.service = service;
//        this.entityToDtoConverter = entityToDtoConverter;
//        this.dtoToEntityConverter = dtoToEntityConverter;
    }

//
//    @PostMapping
//    public D create(@RequestBody D dtoBody){
//        return entityToDtoConverter.apply(service.create(dtoToEntityConverter.apply(dtoBody)));
//    }

    @PostMapping
    public Entity create(@RequestBody Entity body){
        return service.create(body);
    }
    @GetMapping
    public Iterable<Entity> getAll(){
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Entity getById(@PathVariable ID id){
       return service.readById(id);
    }

    @PutMapping
    public Entity update(@RequestBody Entity body){
        return service.update(body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") ID id){
        service.deleteById(id);
    }

}

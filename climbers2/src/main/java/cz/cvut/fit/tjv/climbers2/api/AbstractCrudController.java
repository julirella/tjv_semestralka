package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.AbstractCrudService;
import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Function;

//E - entity type
//ID - entity primary key type
//D - dto type??
public abstract class AbstractCrudController<E extends DomainEntity<ID>, D, ID> {

    protected AbstractCrudService<E, ID> service;
//    protected Function<E, D> entityToDtoConverter;
//    protected Function<D, E> dtoToEntityConverter;

    public AbstractCrudController(AbstractCrudService<E, ID> service/*, Function<E, D> entityToDtoConverter, Function<D, E> dtoToEntityConverter*/) {
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
    public E create(@RequestBody E body){

        return service.create(body);
    }
    @GetMapping
    public Iterable<E> getAll(){
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Optional<E> getById(@PathVariable ID id){
       return service.readById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "ok";
    }

    @PutMapping
    public E update(@RequestBody E body){
        return service.update(body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") ID id){
        service.deleteById(id);
    }

}

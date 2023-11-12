package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.AbstractCrudService;
import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractCrudController<Entity extends DomainEntity<ID>, ID> {

    protected AbstractCrudService<Entity, ID> service;
    protected String name;

    public AbstractCrudController(AbstractCrudService<Entity, ID> service) {
        this.service = service;
    }

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "entity already exists")
    @PostMapping
    public Entity create(@RequestBody Entity body){
        return service.create(body);
    }

    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public Iterable<Entity> getAll(){
        return service.readAll();
    }

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "ID does not exist")
    @GetMapping("/{id}")
    public Entity getById(@PathVariable ID id){
       return service.readById(id);
    }

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "entity with given ID does not exist")
    @PutMapping
    public Entity update(@RequestBody Entity body){
        return service.update(body);
    }

    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "ID does not exist")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") ID id){
        service.deleteById(id);
    }

}

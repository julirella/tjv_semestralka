package cz.cvut.fit.tjv.climbers2.api;

import cz.cvut.fit.tjv.climbers2.business.AbstractCrudService;
import cz.cvut.fit.tjv.climbers2.domain.DomainEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractCrudController<Entity extends DomainEntity<ID>, ID> {

    protected AbstractCrudService<Entity, ID> service;

    public AbstractCrudController(AbstractCrudService<Entity, ID> service) {
        this.service = service;
    }

//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiIgnore // Exclude this exception from OpenAPI documentation
//    })
//    @ApiIgnore
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

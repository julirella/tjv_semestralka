package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.service.AbstractService;

import java.util.Collection;

public class Console<Entity>{
    AbstractService<Entity> service;

    public Console(AbstractService<Entity> service) {
        this.service = service;
    }

    public String create(Entity toCreate){
        try{
            Entity created = service.create(toCreate);
            return "successfully created: " + created.toString();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String readOne(Long id){
        try{
            return service.readById(id).toString();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String readAll() {
        try {
            return service.readAll().toString();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
    public String update(Entity toUpdate){
        try{
            Entity updated = service.update(toUpdate);
            return "successfully updated:" + updated.toString();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String delete(Long id){
        try {
            service.delete(id);
            return "entity with id " + id.toString() + " deleted successfully";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
}

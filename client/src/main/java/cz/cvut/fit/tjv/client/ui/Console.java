package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.AbstractEntity;
import cz.cvut.fit.tjv.client.service.AbstractService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Console<Entity extends AbstractEntity>{
    AbstractService<Entity> service;

    public Console(AbstractService<Entity> service) {
        this.service = service;
    }

    public String create(Entity toCreate){
        try{
            Entity created = service.create(toCreate);
            return "successfully created: " + created.getReadable();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String readOne(Long id){
        try{
            return service.readById(id).getReadable();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String readAll() {
        try {
            List<Entity> entities = service.readAll();
            String toReturn = "";
            for(Entity entity : entities){
                String readable = entity.getReadable();
                toReturn = toReturn + "\n" + readable;
            }
            return toReturn;
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
    public String update(Entity toUpdate){
        try{
            Entity updated = service.update(toUpdate);
            return "successfully updated:" + updated.getReadable();
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

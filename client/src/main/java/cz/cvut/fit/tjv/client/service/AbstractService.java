package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.AbstractClient;
import cz.cvut.fit.tjv.client.domain.AbstractEntity;

import java.util.List;

public class AbstractService <Entity extends AbstractEntity>{
    protected AbstractClient<Entity> client;

    public AbstractService(AbstractClient<Entity> client) {
        this.client = client;
    }

    public String create(Entity toCreate){
//        return client.create(toCreate);
        try{
            Entity created = client.create(toCreate);
            return "successfully created: " + created.getReadable();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
    public String readAll() {
//        return client.readAll();
        try {
            List<Entity> entities = client.readAll();
            String toReturn = "";
            for(Entity entity : entities){
                String readable = entity.getReadableShort();
                toReturn = toReturn + "\n" + readable;
            }
            return toReturn;
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
    public String readById(Long id){
//        return client.readById(id);
        try{
            return client.readById(id).getReadable();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String update(Entity toUpdate){
//        return client.update(toUpdate);
        try{
            Entity updated = client.update(toUpdate);
            return "successfully updated:" + updated.getReadable();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    public String delete(Long id){
        try {
            client.delete(id);
            return "entity with id " + id.toString() + " deleted successfully";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
}

package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.AbstractClient;

import java.util.Collection;

public class AbstractService <Entity>{
    private AbstractClient<Entity> client;

    public AbstractService(AbstractClient<Entity> client) {
        this.client = client;
    }

    public Entity create(Entity toCreate){
        return client.create(toCreate);
    }
    public Collection<Entity> readAll() {
        return client.readAll();
    }
    public Entity readById(Long id){
        return client.readById(id);
    }

    public Entity update(Entity toUpdate){
        return client.update(toUpdate);
    }

    public void delete(Long id){
        client.delete(id);
    }
}

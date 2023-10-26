package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.AbstractClient;

import java.util.Collection;

public class AbstractService <Entity>{
    private AbstractClient<Entity> client;

    public AbstractService(AbstractClient<Entity> client) {
        this.client = client;
    }

    public Collection<Entity> readAll() {
        return client.readAll();
    }
}

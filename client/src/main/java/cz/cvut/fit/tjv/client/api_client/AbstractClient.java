package cz.cvut.fit.tjv.client.api_client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//source: https://docs.oracle.com/javaee/7/tutorial/jaxrs-client001.htm
public class AbstractClient <Entity> {
    private Client client;
    private  String serverUrl;
    private WebTarget endpointPath;

    public AbstractClient(String endpoint) {
        this.client = ClientBuilder.newClient();
//        this.serverUrl = "${server.url}";
        this.serverUrl = "http://localhost:8080";
        this.endpointPath = client.target(serverUrl + endpoint);
    }

    public Collection<Entity> readAll() {
        List<Entity> entities = endpointPath.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Entity>>() {});
        return entities;
    }



}

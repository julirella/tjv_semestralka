package cz.cvut.fit.tjv.client.api_client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

//source: https://docs.oracle.com/javaee/7/tutorial/jaxrs-client001.htm
public class AbstractClient <E> {
    private Client client;
    private  String serverUrl;
    protected WebTarget endpointPath;
    private Class<E> concreteClass;
    private String endpoint;

    public AbstractClient(String endpoint, Class<E> concreteClass) {
        this.concreteClass = concreteClass;
        this.client = ClientBuilder.newClient();
//        this.serverUrl = "${server.url}";
        this.serverUrl = "http://localhost:8080";
        this.endpoint = endpoint;
        this.endpointPath = client.target(serverUrl + endpoint);
    }

    protected WebTarget targetWithId(Long id){
        return client.target(serverUrl + endpoint + "/" + id.toString());
    }
    protected WebTarget targetFromStrings(List<String> strings){
        String path = serverUrl + endpoint;
        for (String s : strings) {
            path = path.concat("/" + s);
        }
        return client.target(path);
    }
    public E create(E toCreate){
        Response response = endpointPath.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(toCreate, MediaType.APPLICATION_JSON_TYPE));
        if(response.getStatus() == 200) return response.readEntity(concreteClass);
        else if(response.getStatus() == 400) throw new RuntimeException(response.readEntity(String.class));
        else throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }
    public Collection<E> readAll() {
        Response response = endpointPath.request(MediaType.APPLICATION_JSON_TYPE).get();
        if(response.getStatus() != 200) throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
        else {
            List<E> entities = response.readEntity(new GenericType<List<E>>() {});
            return entities;
        }
    }

    public E readById(Long id){
        WebTarget path = targetWithId(id);
        Response response = path.request(MediaType.APPLICATION_JSON_TYPE).get();
        if(response.getStatus() == 200) return response.readEntity(concreteClass);
        else if(response.getStatus() == 404) throw new RuntimeException(response.readEntity(String.class));
        else throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }

    public E update(E toUpdate){
        Response response = endpointPath.request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(toUpdate, MediaType.APPLICATION_JSON_TYPE));
        if(response.getStatus() == 200) return response.readEntity(concreteClass);
        else if(response.getStatus() == 404) throw new RuntimeException(response.readEntity(String.class));
        else throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }

    public void delete(Long id){
        WebTarget path = targetWithId(id);
        Response response = path.request(MediaType.APPLICATION_JSON_TYPE).delete();
        if(response.getStatus() == 404) throw new RuntimeException(response.readEntity(String.class));
        else if(response.getStatus() != 200) throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }

}

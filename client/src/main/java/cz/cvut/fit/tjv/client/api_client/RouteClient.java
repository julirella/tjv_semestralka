package cz.cvut.fit.tjv.client.api_client;

import cz.cvut.fit.tjv.client.domain.Route;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class RouteClient extends AbstractClient<Route> {
    public RouteClient() {
        super("/route", Route.class);
    }

    @Override
    public Route create(Route toCreate){
        Response response = endpointPath.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(toCreate, MediaType.APPLICATION_JSON_TYPE));
        if(response.getStatus() == 200) return response.readEntity(Route.class);
        else if(response.getStatus() == 400 || response.getStatus() == 404) throw new RuntimeException(response.readEntity(String.class));
        else throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }
}

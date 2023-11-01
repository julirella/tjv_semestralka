package cz.cvut.fit.tjv.client.api_client;

import cz.cvut.fit.tjv.client.domain.Climber;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
public class ClimberClient extends AbstractClient<Climber>{
    public ClimberClient() {
        super("/climber", Climber.class);
    }

    public Climber addRoute(Long climberId, Long routeId){
        WebTarget path = targetFromStrings(List.of(climberId.toString(), "addRoute", routeId.toString()));
        Response response = path.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(null)); //why not .entity?
        if(response.getStatus() == 200) return response.readEntity(Climber.class);
        else if(response.getStatus() == 400) throw new RuntimeException(response.readEntity(String.class));
        else throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }

    public Climber deleteRoute(Long climberId, Long routeId){
        WebTarget path = targetFromStrings(List.of(climberId.toString(), "deleteRoute", routeId.toString()));
        Response response = path.request(MediaType.APPLICATION_JSON_TYPE).delete();
        if(response.getStatus() == 200) return response.readEntity(Climber.class);
        else if(response.getStatus() == 400) throw new RuntimeException(response.readEntity(String.class));
        else throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
    }
}

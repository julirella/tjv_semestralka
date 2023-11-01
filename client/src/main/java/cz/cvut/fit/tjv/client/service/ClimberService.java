package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.ClimberClient;
import cz.cvut.fit.tjv.client.domain.Climber;
import org.springframework.stereotype.Service;

@Service
public class ClimberService extends AbstractService<Climber>{
    private ClimberClient client;
    public ClimberService(ClimberClient client) {
        super(client);
        this.client = client;
    }
    public Climber addRoute(Long climberId, Long routeId){
        return client.addRoute(climberId, routeId);
    }

    public Climber deleteRoute(Long climberId, Long routeId){
        return client.deleteRoute(climberId, routeId);
    }
}

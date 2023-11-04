package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.ClimberClient;
import cz.cvut.fit.tjv.client.domain.Climber;
import cz.cvut.fit.tjv.client.domain.Route;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Route> recommendRoutes(Long climberId){
        return client.recommendRoutes(climberId);
    }

    public Optional<Integer> calculateStrength(Long climberId){
        Climber climber = client.readById(climberId);
        Collection<Route> climbedRoutes = climber.getRoutes();
        if(climbedRoutes.isEmpty()) return Optional.empty();
        int bestGrade = Collections.max(climbedRoutes, Comparator.comparingInt(Route::getGrade)).getGrade();
        climber.setStrength(bestGrade);
        client.update(climber);
        return Optional.of(bestGrade);
    }
}

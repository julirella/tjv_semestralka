package cz.cvut.fit.tjv.client.service;

import cz.cvut.fit.tjv.client.api_client.RouteClient;
import cz.cvut.fit.tjv.client.domain.Route;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends AbstractService<Route>{
    public RouteService(RouteClient client) {
        super(client);
    }
}

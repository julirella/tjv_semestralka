package cz.cvut.fit.tjv.client.api_client;

import cz.cvut.fit.tjv.client.domain.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteClient extends AbstractClient<Route> {
    public RouteClient() {
        super("/route", Route.class);
    }
}

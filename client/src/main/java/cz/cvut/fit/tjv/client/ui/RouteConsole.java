package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Centre;
import cz.cvut.fit.tjv.client.domain.Route;
import cz.cvut.fit.tjv.client.service.RouteService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class RouteConsole {
    RouteService service;
//    Console<Route> console;

    public RouteConsole(RouteService service) {
        this.service = service;
//        console = new Console<Route>(service);
    }

    @ShellMethod
    public String createRoute(String name, Integer grade, Long centreId){
        return service.create(new Route(null, name, grade, new Centre(centreId, null, null)));
    }
    @ShellMethod
    public String readRoute(Long id){
        return service.readById(id);
    }

    @ShellMethod
    public String readRoutes() {
        return service.readAll();
    }

    @ShellMethod
    public String updateRoute(Long routeId, String name, Integer grade, Long centreId){
        return service.update(new Route(routeId, name, grade, new Centre(centreId, null, null)));
    }

    @ShellMethod
    public String deleteRoute(Long id){
        return service.delete(id);
    }
}

package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Climber;
import cz.cvut.fit.tjv.client.domain.Route;
import cz.cvut.fit.tjv.client.service.ClimberService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ShellComponent
public class ClimberConsole {
    ClimberService service;
//    Console<Climber> console;

    public ClimberConsole(ClimberService service) {
        this.service = service;
//        console = new Console<Climber>(service);
    }

    @ShellMethod
    public String createClimber(String name, String surname, Integer strength, Integer budget){
        return service.create(new Climber(null, name, surname, strength, budget));
    }
    @ShellMethod
    public String readClimber(Long id){
        return service.readById(id);
    }

    @ShellMethod
    String readClimbers() {
        return service.readAll();
    }

    @ShellMethod
    public String updateClimber(Long id, String name, String surname, Integer strength, Integer budget){
        return service.update(new Climber(id, name, surname, strength, budget));
    }

    @ShellMethod
    public String deleteClimber(Long id){
        return service.delete(id);
    }

    @ShellMethod
    public String climberAddRoute(Long climberId, Long routeId){
        try{
            Climber modifiedClimber = service.addRoute(climberId, routeId);
            return "route added to climber\n" + modifiedClimber.getReadable();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public String climberDeleteRoute(Long climberId, Long routeId){
        try{
            Climber modifiedClimber = service.deleteRoute(climberId, routeId);
            return "route deleted from climber\n" + modifiedClimber.getReadable();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public String recommendRoutes(Long climberId){
        try{
            List<Route> routes = service.recommendRoutes(climberId);
            if(routes.isEmpty()) return "There are no available routes for you.";
            String routesString = "";
            for(Route route : routes){
                routesString = routesString + "\n" + route.getReadable();
            }
            return "you should try:\n" + routesString;
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public String calculateStrength(Long climberId){
        try{
            Optional<Integer> newStrength = service.calculateStrength(climberId);
            if(newStrength.isEmpty()) return "cannot calculate, no routes climbed yet";
            else return "strength recalculated to " + newStrength.get();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

}

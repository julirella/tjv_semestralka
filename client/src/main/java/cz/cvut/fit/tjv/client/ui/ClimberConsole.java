package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Climber;
import cz.cvut.fit.tjv.client.domain.Route;
import cz.cvut.fit.tjv.client.service.ClimberService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collection;
import java.util.List;

@ShellComponent
public class ClimberConsole {
    ClimberService service;
    Console<Climber> console;

    public ClimberConsole(ClimberService service) {
        this.service = service;
        console = new Console<Climber>(service);
    }

    @ShellMethod
    public String createClimber(String name, String surname, Integer strength, Integer budget){
        return console.create(new Climber(null, name, surname, strength, budget));
    }
    @ShellMethod
    public String readClimber(Long id){
        return console.readOne(id);
    }

    @ShellMethod
    public Collection<Climber> readClimbers() {
        return console.readAll();
    }

    @ShellMethod
    public String updateClimber(Long id, String name, String surname, Integer strength, Integer budget){
        return console.update(new Climber(id, name, surname, strength, budget));
    }

    @ShellMethod
    public String deleteClimber(Long id){
        return console.delete(id);
    }

    @ShellMethod
    public String climberAddRoute(Long climberId, Long routeId){
        try{
            Climber modifiedClimber = service.addRoute(climberId, routeId);
            return "route added to climber\n" + modifiedClimber.toString();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public String climberDeleteRoute(Long climberId, Long routeId){
        try{
            Climber modifiedClimber = service.deleteRoute(climberId, routeId);
            return "route deleted from climber\n" + modifiedClimber.toString();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public String recommendRoutes(Long climberId){
        try{
            List<Route> routes = service.recommendRoutes(climberId);
            return "you should try:\n" + routes.toString();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

}

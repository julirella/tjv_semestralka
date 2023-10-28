package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Climber;
import cz.cvut.fit.tjv.client.service.ClimberService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collection;

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
}

package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Centre;
import cz.cvut.fit.tjv.client.service.CentreService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Collection;
import java.util.Optional;

@ShellComponent
public class CentreConsole {
    CentreService service;

    public CentreConsole(CentreService service) {
        this.service = service;
    }

    @ShellMethod(key = "hello")
    public String hello() {
        return "hello";
    }

//    @ShellMethod(key = "getCentre")
//    public Optional<Centre> readCentre(@ShellOption Integer id){
//
//    }

    @ShellMethod
    public Collection<Centre> readAllCentres() {
        return service.readAll();
    }
}

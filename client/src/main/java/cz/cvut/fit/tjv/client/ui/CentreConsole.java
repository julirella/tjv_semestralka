package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Centre;
import cz.cvut.fit.tjv.client.service.CentreService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Collection;

@ShellComponent
public class CentreConsole {
    CentreService service;
//    Console<Centre> console;

    public CentreConsole(CentreService service) {
        this.service = service;
//        console = new Console<Centre>(service);
    }

    @ShellMethod(key = "hello")
    public String hello(@ShellOption(defaultValue = "false") Boolean flag) {
        return flag.toString();
    }

    @ShellMethod
    public String createCentre(String name, Integer price){
        return service.create(new Centre(null, name, price));
    }
    @ShellMethod
    public String readCentre(Long id){
        return service.readById(id);
    }

    @ShellMethod
    public String readCentres() {
        return service.readAll();
    }

    @ShellMethod
    public String updateCentre(Long id, String name, Integer price){
        return service.update(new Centre(id, name, price));
    }

    @ShellMethod
    public String deleteCentre(Long id){
        return service.delete(id);
    }
}

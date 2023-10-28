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

    @ShellMethod
    public String createCentre(String name, Integer price){
        try{
            Centre createdCentre = service.create(new Centre(null, name, price));
            return "centre created successfully: " + createdCentre.toString();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
    @ShellMethod()
    public String readCentre(Long id){
        try{
            return service.readById(id).toString();
        } catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public Collection<Centre> readCentres() {
        return service.readAll();
    }

    @ShellMethod
    public String updateCentre(Long id, String name, Integer price){
        try{
            Centre updatedCentre = service.update(new Centre(id, name, price));
            return "centre updated successfully: " + updatedCentre.toString();
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }

    @ShellMethod
    public String deleteCentre(Long id){
        try {
            service.delete(id);
            return "centre with id " + id.toString() + " deleted successfully";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }
}

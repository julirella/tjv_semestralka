package cz.cvut.fit.tjv.client.ui;

import cz.cvut.fit.tjv.client.domain.Centre;
import cz.cvut.fit.tjv.client.service.CentreService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CentreConsole {
    CentreService service;

    public CentreConsole(CentreService service) {
        this.service = service;
    }

    @ShellMethod(value = "Create a centre with the given parameters.")
    public String createCentre(String name, Integer price){
        return service.create(new Centre(null, name, price));
    }
    @ShellMethod(value = "Print information about the centre with the given id.")
    public String readCentre(Long id){
        return service.readById(id);
    }

    @ShellMethod(value = "Print information about all centres.")
    public String readCentres() {
        return service.readAll();
    }

    @ShellMethod(value = "Update a centre with the given parameters.")
    public String updateCentre(Long id, String name, Integer price){
        return service.update(new Centre(id, name, price));
    }

    @ShellMethod(value = "Delete the centre with the given id.")
    public String deleteCentre(Long id){
        return service.delete(id);
    }
}

package cz.cvut.fit.tjv.client.ui;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CentreConsole {
    @ShellMethod(key = "hello")
    public String hello() {
        return "hello";
    }
}

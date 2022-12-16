package cz.cvut.fit.tjv.climbers.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.*;

public class Climber implements Serializable, DomainEntity<Long>{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Integer address;
    //maybe implement address as coordinates or something and then calculate distances
    private Integer strength; //or some kind of enum??
    private Integer budget;
    @OneToMany
    private Set<Route> routes;

    public Long getID() {
        return id;
    }
}

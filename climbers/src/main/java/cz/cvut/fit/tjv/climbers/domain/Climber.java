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
    private Set<Route> routes = new HashSet<>();


    public Long getID() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void addRoute(Route route) {
        routes.add(route);
    }
}

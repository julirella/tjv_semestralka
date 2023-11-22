package cz.cvut.fit.tjv.climbers2.domain;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Climber implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Integer strength;
    private Integer budget;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "route_climber")
    private Set<Route> routes = new HashSet<>();

    public Climber(Long id, String name, String surname, Integer strength, Integer budget) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.strength = strength;
        this.budget = budget;
    }

    public Climber(String name, String surname, Integer strength, Integer budget) {
        this.name = name;
        this.surname = surname;
        this.strength = strength;
        this.budget = budget;
    }

    public Climber() {}

    @Override
    public Long getId() {
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

    public void addRoute(Route route){
        routes.add(route);
    }

    public void deleteRoute(Route route) {
        routes.remove(route); //should this be in repository somehow?
    }
}

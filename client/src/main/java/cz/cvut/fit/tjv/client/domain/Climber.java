package cz.cvut.fit.tjv.client.domain;

import java.util.Collection;

public class Climber implements AbstractEntity{
    private Long id;
    private String name;
    private String surname;
    private Integer strength;
    private Integer budget;

    private Collection<Route> routes;

    public Climber(Long id, String name, String surname, Integer strength, Integer budget) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.strength = strength;
        this.budget = budget;
    }

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

    public Collection<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", strength=" + strength +
                ", budget=" + budget +
                ", routes=" + routes +
                '}';
    }

    @Override
    public String getReadable() {
        String climber = "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", strength=" + strength +
                ", budget=" + budget;
        String readableRoutes = "";
        for (Route route : this.routes){
            readableRoutes = "\n" + route.getReadable();
        }
        return climber + readableRoutes;
    }

    @Override
    public String getReadableShort() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", strength=" + strength +
                ", budget=" + budget +
                ", number of routes climbed=" + routes.size();
    }
}

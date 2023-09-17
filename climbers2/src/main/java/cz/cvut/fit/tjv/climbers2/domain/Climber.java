package cz.cvut.fit.tjv.climbers2.domain;

import javax.persistence.*;
import java.io.Serializable;

//@Table??
@Entity
public class Climber implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Integer address;
    //maybe implement address as coordinates or something and then calculate distances
    private Integer strength; //or some kind of enum??
    private Integer budget;

    public Climber(Long id, String name, String surname, Integer address, Integer strength, Integer budget) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.strength = strength;
        this.budget = budget;
    }

    public Climber(String name, String surname, Integer address, Integer strength, Integer budget) {
        this.name = name;
        this.surname = surname;
        this.address = address;
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

    @Override
    public String toString() {
        return "Climber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", strength=" + strength +
                ", budget=" + budget +
                '}';
    }
}

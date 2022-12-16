package cz.cvut.fit.tjv.climbers.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.*;


public class Centre implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer address;
    private Integer price;
    @OneToMany
    private Set<Route> routes;

    public Long getID() {
        return id;
    }
}

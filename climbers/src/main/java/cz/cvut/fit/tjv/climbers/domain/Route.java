package cz.cvut.fit.tjv.climbers.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Date;

public class Route implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer grade;
    private Integer type; //also maybe enum
    private Date dateBuilt;
    private Date dateRemoved;
    @ManyToOne
    private Centre centre;

    public Long getID() {
        return id;
    }
}

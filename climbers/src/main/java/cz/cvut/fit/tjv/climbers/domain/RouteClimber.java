package cz.cvut.fit.tjv.climbers.domain;

import cz.cvut.fit.tjv.climbers.domain.Climber;
import cz.cvut.fit.tjv.climbers.domain.Route;
import jakarta.persistence.*;

import java.io.Serializable;


public class RouteClimber implements Serializable, DomainEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Climber climber;
    @ManyToOne
    private Route route;
    private Boolean climbed;
    private Boolean wantsToClimb;
    private Integer attempts;

    public Long getID() {
        return id;
    }

}

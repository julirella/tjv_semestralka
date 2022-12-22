package cz.cvut.fit.tjv.climbers2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class RouteClimber implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private Boolean climbed;
    private Boolean wantsToClimb;
    private Integer attempts;
    @ManyToOne
    private Route route;
    @ManyToOne
    private Climber climber;

    public RouteClimber(Long id, Boolean climbed, Boolean wantsToClimb, Integer attempts, Route route, Climber climber) {
        this.id = id;
        this.climbed = climbed;
        this.wantsToClimb = wantsToClimb;
        this.attempts = attempts;
        this.route = route;
        this.climber = climber;
    }

    public RouteClimber() {

    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getClimbed() {
        return climbed;
    }

    public void setClimbed(Boolean climbed) {
        this.climbed = climbed;
    }

    public Boolean getWantsToClimb() {
        return wantsToClimb;
    }

    public void setWantsToClimb(Boolean wantsToClimb) {
        this.wantsToClimb = wantsToClimb;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Climber getClimber() {
        return climber;
    }

    public void setClimber(Climber climber) {
        this.climber = climber;
    }
}

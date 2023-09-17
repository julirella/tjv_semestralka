package cz.cvut.fit.tjv.climbers2.api.model;

import cz.cvut.fit.tjv.climbers2.domain.Climber;
import cz.cvut.fit.tjv.climbers2.domain.Route;


public class RouteClimberDto {
    private Long id;
    private Boolean climbed;
    private Boolean wantsToClimb;
    private Integer attempts;
    private Route route;
    private Climber climber;

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

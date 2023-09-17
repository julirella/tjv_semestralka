package cz.cvut.fit.tjv.climbers2.api.model;

import cz.cvut.fit.tjv.climbers2.domain.Centre;

import javax.persistence.ManyToOne;
import java.util.Date;

public class RouteDto {
    private Long id;
    private String name;

    private Integer grade;
    private Integer type;
    private Date dateBuilt;
    private Date dateTakenDown;
    private Centre centre;

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDateBuilt() {
        return dateBuilt;
    }

    public void setDateBuilt(Date dateBuilt) {
        this.dateBuilt = dateBuilt;
    }

    public Date getDateTakenDown() {
        return dateTakenDown;
    }

    public void setDateTakenDown(Date dateTakenDown) {
        this.dateTakenDown = dateTakenDown;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}

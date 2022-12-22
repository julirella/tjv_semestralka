package cz.cvut.fit.tjv.climbers2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Route implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Integer grade;
    private Integer type;
    private Date dateBuilt;
    private Date dateTakenDown;
    @ManyToOne
    private Centre centre;

    public Route(Long id, String name, Integer grade, Integer type, Date dateBuilt, Date dateTakenDown, Centre centre) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.type = type;
        this.dateBuilt = dateBuilt;
        this.dateTakenDown = dateTakenDown;
        this.centre = centre;
    }

    public Route() {

    }

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

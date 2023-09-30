package cz.cvut.fit.tjv.climbers2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Route implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Integer grade;
    @ManyToOne
    private Centre centre;

    public Route(Long id, String name, Integer grade, Centre centre) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.centre = Objects.requireNonNull(centre);
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

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}

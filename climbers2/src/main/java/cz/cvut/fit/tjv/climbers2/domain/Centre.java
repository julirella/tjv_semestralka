package cz.cvut.fit.tjv.climbers2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Centre implements Serializable, DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer address;
    private Integer price;
//   @OneToMany(mappedBy = "centre")
//    private List<Route> routes;

    public Centre(Long id, String name, Integer address, Integer price) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
    }

    public Centre() {

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

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

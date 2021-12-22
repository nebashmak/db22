package com.ChaoticChaotic.db2.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "towns")
public class Towns {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "town_id", nullable = false)
    private Long id;

    @Column(name = "town_name", length = 30)
    private String name;

    @Column(name = "distance", nullable = false)
    private Long distance;

    @OneToOne(mappedBy = "town")
    private Shippings shipping;

    public Towns() {
    }

    public Towns(String name, Long distance) {
        this.name = name;
        this.distance = distance;
    }

    public Towns(Long id, String name, Long distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.shipping = shipping;
    }


    public Long getTownId() {
        return id;
    }

    public String getTownName() {
        return name;
    }

    public void setTownName(String town_name) {
        this.name = town_name;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Towns towns = (Towns) o;
        return Objects.equals(id, towns.id) && Objects.equals(name, towns.name) && Objects.equals(distance, towns.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, distance);
    }

    @Override
    public String toString() {
        return "Towns{" +
                "town_id=" + id +
                ", town_name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}

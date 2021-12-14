package com.ChaoticChaotic.db2.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "shippings")
public class Shippings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "items_id")
    private Items item;

    @OneToOne(optional = false)
    @JoinColumn(name = "town_id")
    private Towns town;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    public Shippings() {
    }

    public Shippings(Items item, Towns town, Date startDate, Date endDate) {
        this.item = item;
        this.town = town;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Shippings(Long id, Items item, Towns town, Date startDate) {
        this.id = id;
        this.item = item;
        this.town = town;
        this.startDate = startDate;
    }


    public Long getShipping_id() {
        return id;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Towns getTown() {
        return town;
    }

    public void setTown(Towns town) {
        this.town = town;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start_date) {
        this.startDate = start_date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shippings shippings = (Shippings) o;
        return Objects.equals(id, shippings.id) && Objects.equals(item, shippings.item) && Objects.equals(town, shippings.town) && Objects.equals(startDate, shippings.startDate) && Objects.equals(endDate, shippings.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, town, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Shippings{" +
                "shipping_id=" + id +
                ", item=" + item +
                ", town=" + town +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                '}';
    }
}

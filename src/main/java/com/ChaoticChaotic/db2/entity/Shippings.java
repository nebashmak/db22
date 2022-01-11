package com.ChaoticChaotic.db2.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "shippings")
public class Shippings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id", nullable = false)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "town_id",referencedColumnName = "town_id")
    private Towns town;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "items_id", referencedColumnName = "item_id")
    private Items item;


    public Shippings(Long id, LocalDate startDate, LocalDate endDate, Towns town, Items item) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.item = item;
        this.town = town;
    }

    public Shippings(LocalDate startDate, LocalDate endDate, Towns town, Items item) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.item = item;
        this.town = town;
    }

    public Shippings() {
    }


    public Long getShippingId() {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate start_date) {
        this.startDate = start_date;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

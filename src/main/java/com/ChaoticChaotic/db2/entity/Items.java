package com.ChaoticChaotic.db2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name", length = 30)
    private String name;

    @Column(name = "quantity",nullable = false )
    private Long quantity;


    public Items() {
    }

    public Items(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Long getItemId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return Objects.equals(id, items.id) && Objects.equals(name, items.name) && Objects.equals(quantity, items.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity);
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_id=" + id +
                ", item_name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}

package com.food.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {

    @Column(name = "datetime", nullable = false)
    @NotNull
    private LocalDateTime dateCreate;

    @Column(name = "price", nullable = false)
    @NotNull
    private float price;

    @Column(name = "restaurant_Id", nullable = false)
    @NotNull
    private int restaurantId;

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "dateCreate=" + dateCreate +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                '}';
    }
}

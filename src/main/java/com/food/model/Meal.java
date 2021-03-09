package com.food.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {

    @Column(name = "datetime")
    private LocalDateTime dateCreate;
    private float price;

    @Column(name = "restaurant_Id")
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

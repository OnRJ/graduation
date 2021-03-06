package com.food.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "datetime")
    private LocalDateTime dateCreate;

    @Column(name = "restaurant_Id")
    private int restaurantId;

    @Column(name = "user_Id")
    private int userId;

    public Vote() {

    }

    public Vote(int id, LocalDateTime dateCreate, int restaurantId, int userId) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", restaurantId=" + restaurantId +
                ", userId=" + userId +
                '}';
    }
}

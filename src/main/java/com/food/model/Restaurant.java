package com.food.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @Override
    public String toString() {
        return super.toString();
    }
}

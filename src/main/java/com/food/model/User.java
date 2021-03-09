package com.food.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                '}';
    }
}

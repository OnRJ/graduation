package com.food.service;

import com.food.exception.BadRequestException;
import com.food.exception.RestaurantNotFoundException;
import com.food.model.Restaurant;
import com.food.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    @Autowired
    public void setMealRepository(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant update(int id, Restaurant modifiedRestaurant) {

        //checkParams(modifiedRestaurant);

        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant is not found"));

        if (modifiedRestaurant.getName() != null) {
            restaurant.setName(modifiedRestaurant.getName());
        }

        return repository.save(restaurant);
    }

    public int checkId(String id) {
        if (id == null || id.equals("0") || id.equals("")) {
            throw new BadRequestException("ID is incorrect");
        }
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException("ID is not a number", e);
        }
    }
}
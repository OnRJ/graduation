package com.food.controller;

import com.food.model.Restaurant;
import com.food.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.food.util.ValidationUtil.checkId;

@RestController
@RequestMapping("/rest")
public class RestaurantController {

    private RestaurantService service;

    @Autowired
    public void setService(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("/restaurants")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @PostMapping("/restaurants")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return service.create(restaurant);
    }

    @PostMapping("/restaurants/restaurantId={id}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant update(@PathVariable String id, @RequestBody Restaurant restaurant) {
        int restaurantId = checkId(id);
        return service.update(restaurantId, restaurant);
    }
}

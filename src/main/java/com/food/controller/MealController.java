package com.food.controller;

import com.food.model.Meal;
import com.food.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MealController {

    private MealService service;

    @Autowired
    public void setService(MealService service) {
        this.service = service;
    }

    @GetMapping("/meals/restaurantId={id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Meal> getCount(@PathVariable String id) {
        int restaurantId = service.checkId(id);
        return service.getAll(restaurantId);
    }

    @PostMapping("/meals")
    @ResponseStatus(HttpStatus.OK)
    public Meal create(@RequestBody Meal meal) {
        return service.create(meal);
    }
}
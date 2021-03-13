package com.food.controller;

import com.food.model.Meal;
import com.food.service.MealService;
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
public class MealController {

    private MealService service;

    @Autowired
    public void setService(MealService service) {
        this.service = service;
    }

    @GetMapping("/meals/restaurantId={id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Meal> getAll(@PathVariable String id) {
        int restaurantId = checkId(id);
        return service.getAll(restaurantId);
    }

    @PostMapping("/meals")
    @ResponseStatus(HttpStatus.OK)
    public Meal create(@RequestBody Meal meal) {
        return service.create(meal);
    }
}

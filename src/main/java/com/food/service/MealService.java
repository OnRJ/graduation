package com.food.service;

import com.food.util.exception.BadRequestException;
import com.food.model.Meal;
import com.food.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {
    private MealRepository repository;

    @Autowired
    public void setMealRepository(MealRepository repository) {
        this.repository = repository;
    }

    public List<Meal> getAll(int restaurantId) {
        return repository.findAll().stream()
                .filter(meal -> (meal.getRestaurantId() == restaurantId)
                        && (meal.getDateCreate().toLocalDate().equals(LocalDateTime.now().toLocalDate())))
                .collect(Collectors.toList());
    }

    public Meal create(Meal meal) {
        meal.setDateCreate(LocalDateTime.now());
        return repository.save(meal);
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

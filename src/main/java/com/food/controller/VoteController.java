package com.food.controller;

import com.food.model.Vote;
import com.food.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.food.util.ValidationUtil.checkId;

@RestController
@RequestMapping("/rest")
public class VoteController {

    private VoteService service;

    @Autowired
    public void setService(VoteService service) {
        this.service = service;
    }

    @GetMapping("/votes/restaurantId={id}/count")
    @ResponseStatus(HttpStatus.OK)
    public long getCount(@PathVariable String id) {
        int restaurantId = checkId(id);
        return service.getCount(restaurantId);
    }

    @PostMapping("/votes")
    @ResponseStatus(HttpStatus.OK)
    public Vote create(@RequestBody Vote vote) {
        return service.create(vote);
    }
}

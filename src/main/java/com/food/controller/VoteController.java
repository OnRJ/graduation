package com.food.controller;

import com.food.model.Vote;
import com.food.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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

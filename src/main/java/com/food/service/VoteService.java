package com.food.service;

import com.food.model.Vote;
import com.food.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteService {

    private VoteRepository repository;

    @Autowired
    public void setVoteRepository(VoteRepository repository) {
        this.repository = repository;
    }

    public long getCount(int restaurantId) {
        return getVotesCountToday(restaurantId);
    }

    public Vote create(Vote vote) {
        List<Vote> userVote = getVotesByUserToday(vote.getUserId());

        if (userVote.size() >= 1 && LocalDateTime.now().getHour() < 11) {
            repository.delete(userVote.get(0));
        } else if(userVote.size() >= 1 && LocalDateTime.now().getHour() >= 11) {
            System.out.println("Сегодня уже нет возможности проголосовать");
        } else {
            vote.setDateCreate(LocalDateTime.now());
            repository.save(vote);
        }
        return vote;
    }

    private List<Vote> getVotesByUserToday(int userId) {
        return repository.findAll().stream()
                .filter(vote -> (vote.getUserId() == userId)
                        && (vote.getDateCreate().toLocalDate().equals(LocalDateTime.now().toLocalDate())))
                .collect(Collectors.toList());
    }

    private Long getVotesCountToday(int restaurantId) {
        return repository.findAll().stream()
                .filter(vote -> (vote.getRestaurantId() == restaurantId)
                    && (vote.getDateCreate().toLocalDate().equals(LocalDateTime.now().toLocalDate())))
                .count();
    }
}

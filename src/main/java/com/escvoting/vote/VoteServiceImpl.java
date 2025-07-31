package com.escvoting.vote;

import com.escvoting.music.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;


    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote saveVote(Vote vote){
        return VoteRepository.save(vote);
    }

    List<Vote> getVotesByUserId(int userId);
    Vote getVoteByMusicId(int id);
}

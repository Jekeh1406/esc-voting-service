package com.escvoting.vote;

import com.escvoting.user.User;

import java.util.List;

public interface VoteService {
    Vote saveVote(Vote vote);
    List<Vote> getVotesByUserId(int userId);
    Vote getVoteByMusicId(int id);
}

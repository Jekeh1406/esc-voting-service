package com.escvoting.vote;

import com.escvoting.music.Music;
import com.escvoting.user.User;

import java.util.List;

public interface VoteService {
    Vote createVote(User user, Music music,
                    double musicNote, double voiceNote,
                    double interpretationNote, double showNote);

    List<Vote> getAllVotes();

    List<Vote> getVotesByUser(User user);

    List<Vote> getVotesByMusic(Music music);

    double getAverageScoreForMusic(Music music);
}

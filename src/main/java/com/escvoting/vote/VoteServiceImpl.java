package com.escvoting.vote;

import com.escvoting.music.Music;
import com.escvoting.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote createVote(User user, Music music,
                           double musicNote, double voiceNote,
                           double interpretationNote, double showNote) {

        Optional<Vote> existingVote = voteRepository.findByUserAndMusic(user, music);
        if (existingVote.isPresent()) {
            throw new IllegalStateException("L'utilisateur a déjà voté pour cette musique.");
        }

        Vote vote = new Vote(user, music, musicNote, voiceNote, interpretationNote, showNote);
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public List<Vote> getVotesByUser(User user) {
        return voteRepository.findAll().stream()
                .filter(v -> v.getUser().equals(user))
                .toList();
    }

    @Override
    public List<Vote> getVotesByMusic(Music music) {
        return voteRepository.findAll().stream()
                .filter(v -> v.getMusic().equals(music))
                .toList();
    }

    @Override
    public double getAverageScoreForMusic(Music music) {
        List<Vote> votes = getVotesByMusic(music);
        if (votes.isEmpty()) return 0;

        return votes.stream()
                .mapToDouble(v -> (
                        v.getMusicNote() +
                                v.getVoiceNote() +
                                v.getInterpretationNote() +
                                v.getShowNote()) / 4.0)
                .average()
                .orElse(0);
    }
}

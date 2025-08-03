package com.escvoting.vote;

import com.escvoting.music.Music;
import com.escvoting.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Optional<Vote> findByUserAndMusic(User user, Music music);
}

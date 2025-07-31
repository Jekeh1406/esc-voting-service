package com.escvoting.vote;

import com.escvoting.music.Music;
import com.escvoting.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "votes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "song_id"})
})
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "song_id")
    private Music music;

    @Column(nullable = false)
    private int scoreMusic;

    @Column(nullable = false)
    private int scoreSinging;

    @Column(nullable = false)
    private int scoreInterpretation;

    @Column(nullable = false)
    private int scoreChoreography;

    public Vote() {}

    public Vote(User user, Music music, int scoreMusic, int scoreSinging, int scoreInterpretation, int scoreChoreography) {
        this.user = user;
        this.music = music;
        this.scoreMusic = scoreMusic;
        this.scoreSinging = scoreSinging;
        this.scoreInterpretation = scoreInterpretation;
        this.scoreChoreography = scoreChoreography;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Music getMusic() {
        return music;
    }

    public int getScoreMusic() {
        return scoreMusic;
    }

    public void setScoreMusic(int scoreMusic) {
        this.scoreMusic = scoreMusic;
    }

    public int getScoreSinging() {
        return scoreSinging;
    }

    public void setScoreSinging(int scoreSinging) {
        this.scoreSinging = scoreSinging;
    }

    public int getScoreInterpretation() {
        return scoreInterpretation;
    }

    public void setScoreInterpretation(int scoreInterpretation) {
        this.scoreInterpretation = scoreInterpretation;
    }

    public int getScoreChoreography() {
        return scoreChoreography;
    }

    public void setScoreChoreography(int scoreChoreography) {
        this.scoreChoreography = scoreChoreography;
    }
}

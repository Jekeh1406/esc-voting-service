package com.escvoting.vote;


import com.escvoting.music.Music;
import com.escvoting.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vote", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "music_id"})
})

public class Vote {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "music_id", nullable = false)
    private Music music;
    private double musicNote;
    private double voiceNote;
    private double interpretationNote;
    private double showNote;

    public Vote() {
    }

    public Vote(User user, Music music, double musicNote, double voiceNote, double interpretationNote, double showNote) {
        this.user = user;
        this.music = music;
        this.musicNote = musicNote;
        this.voiceNote = voiceNote;
        this.interpretationNote = interpretationNote;
        this.showNote = showNote;
    }
}

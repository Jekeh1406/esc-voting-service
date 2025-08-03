package com.escvoting.music;


import com.escvoting.country.Country;
import com.escvoting.vote.Vote;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String artist;
    private String title;
    @ManyToOne
    private Country country;

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @OneToMany(mappedBy = "music", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vote> votes;

    public Music(Country country, String musicName, String singer, Long id) {
        this.country = country;
        this.title = musicName;
        this.artist = singer;
        this.id = id;
    }

    public Music() {

    }
}

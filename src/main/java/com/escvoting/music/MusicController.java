package com.escvoting.music;

import com.escvoting.country.Country;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping
    public Music createMusic(@RequestBody Music music) {
        return musicService.saveMusic(music);
    }

    @GetMapping
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }

    @GetMapping("/{id}")
    public Music getMusicById(@PathVariable Long id) {
        return musicService.getMusicById(id);
    }

    @GetMapping("/music/{code}")
    public List<Music> getMusicByCountry(@PathVariable String id) {
        return musicService.getMusicByCountryCode(id);
    }
}

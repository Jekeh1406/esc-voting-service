package com.escvoting.music;

import com.escvoting.country.Country;
import com.escvoting.country.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("music")
public class MusicController {

    private final MusicService musicService;

    private final CountryRepository countryRepository;

    public MusicController(MusicService musicService, CountryRepository countryRepository) {
        this.musicService = musicService;
        this.countryRepository = countryRepository;
    }

    @PostMapping()
    public ResponseEntity<Music> createMusic(@RequestBody CreateMusicDTO dto) {
        Country country = countryRepository.findByCode(dto.getCountryCode().toUpperCase());

        Music music = new Music();
        music.setTitle(dto.getTitle());
        music.setArtist(dto.getArtist());
        music.setCountry(country);

        musicService.saveMusic(music);

        return ResponseEntity.status(HttpStatus.CREATED).body(music);
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

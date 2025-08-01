package com.escvoting.music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveMusic(Music music ) {
        return musicRepository.save(music);
    }

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music getMusicById(Long id) {
        return musicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Music not found with id: " + id));
    }

    @Override
    public List<Music> getMusicByCountryCode(String code) {
        return musicRepository.findByCountryCode(code);
    }
}

package com.escvoting.music;

import java.util.List;

public interface MusicService {
    Music saveMusic(Music music);
    List<Music> getAllMusic();
    Music getMusicById(Long id);
    List<Music> getMusicByCountryCode(String code);
}

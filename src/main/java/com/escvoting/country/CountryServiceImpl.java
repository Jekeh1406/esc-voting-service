package com.escvoting.country;
import com.escvoting.music.Music;
import com.escvoting.music.MusicRepository;
import com.escvoting.music.MusicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country saveCountry(Country country ) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryByCode(String countryCode) {
        return countryRepository.findByCode(countryCode);
    }

    @Override
    public void deleteCountry(String countryCode) {
        countryRepository.deleteByCode(countryCode);
    }
}

package com.escvoting.country;
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
    public Country getCountryById(int id) {
        return null;
    }

    @Override
    public void deleteCountry(String countryCode) {
        countryRepository.deleteByCode(countryCode);
    }
}

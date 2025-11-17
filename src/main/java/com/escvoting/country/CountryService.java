package com.escvoting.country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country);
    List<Country> getAllCountries();
    Country getCountryById(int id);

    void deleteCountry(String countryCode);
}

package com.escvoting.country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country);
    List<Country> getAllCountries();
    Country getCountryByCode(String countryCode);

    void deleteCountry(String countryCode);
}

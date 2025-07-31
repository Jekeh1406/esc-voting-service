package com.escvoting.country;

import java.util.List;

public class CountryService {
    Country saveCountry(Country country);
    List<Country> getAllCountries();
    Country getCountryByCode(String countryCode);
}

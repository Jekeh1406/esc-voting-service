package com.escvoting.country;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @GetMapping
    public List<Country> getAllMusic() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryByCode(@PathVariable String countryCode) {
        return countryService.getCountryByCode(countryCode);
    }

}

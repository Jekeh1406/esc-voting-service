package com.escvoting.country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
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
}

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

    @GetMapping("/{countryCode}")
    public Country getCountryByCode(@PathVariable String countryCode) {
        return countryService.getCountryByCode(countryCode);
    }

    @DeleteMapping("/{countryCode}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String countryCode) {
        countryService.deleteCountry(countryCode);
        return ResponseEntity.noContent().build();  // Renvoie un statut 204 (No Content) après suppression
    }


}

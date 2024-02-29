package guru.qa.country.controller;

import guru.qa.country.model.Country;
import guru.qa.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @PostMapping("/country")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        if (country.countryCode() == null && country.countryName() == null) {
            return new ResponseEntity("reduundant param: countryCode and countryName should not be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (country.countryCode() == null || country.countryName() == null) {
            return new ResponseEntity("reduundant param: countryCode or countryName should not be null", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(countryService.addCountry(country));
    }

    @PatchMapping("/{countryName}")
    public Country updCountryName(@PathVariable String countryName,
                                  @RequestBody String newCountryName) {
        return countryService.updName(countryName, newCountryName);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCountry(@PathVariable("id") UUID id) {
        try {
            countryService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}

package guru.qa.country.service;

import guru.qa.country.data.CountryEntity;
import guru.qa.country.data.CountryRepository;
import guru.qa.country.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }

    public Country addCountry(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName(country.countryName());
        countryEntity.setCountryCode(country.countryCode());
        countryRepository.save(countryEntity);
        return Country.fromEntity(countryEntity);
    }

    public Country updName(String countryName, String newCountryName) {
        CountryEntity countryEntity =  countryRepository.findByCountryName(countryName);
        countryEntity.setCountryName(newCountryName);
        countryRepository.save(countryEntity);
        return Country.fromEntity(countryEntity);
    }

    public void deleteById(UUID id) {
        countryRepository.deleteById(id);
    }


}

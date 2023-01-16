package com.worlds_events_api.worldseventsapi.countries;

import com.worlds_events_api.worldseventsapi.countries.request.AddCountryRequest;
import com.worlds_events_api.worldseventsapi.countries.responses.CountryResponse;
import com.worlds_events_api.worldseventsapi.database.entities.Country;
import com.worlds_events_api.worldseventsapi.database.repositories.ICountriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CountriesService {
    private final ICountriesRepo countriesRepo;

    @Autowired
    public CountriesService(ICountriesRepo countriesRepo) {
        this.countriesRepo = countriesRepo;
    }

    public ArrayList<CountryResponse> GetAllCountries() throws Exception {
        try{
            var arr = new ArrayList<CountryResponse>();

            var countries = countriesRepo.findAll();

            countries.forEach(c -> arr.add(new CountryResponse(c.getId(), c.getCountry())));

            return arr;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public boolean AddCountry(AddCountryRequest addCountryRequest) throws Exception {
        try{
            var country = new Country(addCountryRequest.country);

            countriesRepo.save(country);

            return true;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}

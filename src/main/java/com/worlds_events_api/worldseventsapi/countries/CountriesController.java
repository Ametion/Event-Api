package com.worlds_events_api.worldseventsapi.countries;

import com.worlds_events_api.worldseventsapi.countries.request.AddCountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountriesController {
    private final CountriesService countriesService;

    @Autowired
    public CountriesController(CountriesService countriesService){
        this.countriesService = countriesService;
    }

    @GetMapping
    public ResponseEntity GetAllCountries(){
        try{
            return ResponseEntity.ok(countriesService.GetAllCountries());
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity AddCountry(@RequestBody AddCountryRequest addCountryRequest){
        try{
            return ResponseEntity.ok(countriesService.AddCountry(addCountryRequest));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

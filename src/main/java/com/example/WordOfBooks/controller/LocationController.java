package com.example.WordOfBooks.controller;

import com.example.WordOfBooks.domain.Location;
import com.example.WordOfBooks.domain.dto.LocationDto;
import com.example.WordOfBooks.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("https://my.api.mockaroo.com")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/location")
    public ResponseEntity<?> getLocation() {
        ResponseEntity<LocationDto[]> rspey = restTemplate.getForEntity("https://my.api.mockaroo.com/location?key=63304c70",LocationDto[].class);
        LocationDto[] locationArray = rspey.getBody();
        List<LocationDto> data = Arrays.asList(locationArray);
        this.locationService.createLocation(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

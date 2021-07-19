package com.example.WordOfBooks.service;

import com.example.WordOfBooks.domain.Location;
import com.example.WordOfBooks.domain.dto.LocationDto;
import com.example.WordOfBooks.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> createLocation(List<LocationDto> location){
        List<Location> result = location.stream().map(Location::new).collect(Collectors.toList());
        return this.locationRepository.saveAll(result);
    }
}

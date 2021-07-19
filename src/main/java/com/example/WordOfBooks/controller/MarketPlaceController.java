package com.example.WordOfBooks.controller;

import com.example.WordOfBooks.domain.Location;
import com.example.WordOfBooks.domain.MarketPlace;
import com.example.WordOfBooks.domain.dto.LocationDto;
import com.example.WordOfBooks.domain.dto.MarketPlaceDto;
import com.example.WordOfBooks.service.MarketPlaceService;
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
public class MarketPlaceController {

    private final MarketPlaceService marketPlaceService;

    @Autowired
    public MarketPlaceController(MarketPlaceService marketPlaceService) {
        this.marketPlaceService = marketPlaceService;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/marketplace")
    public ResponseEntity<?> getMarketPlace() {
        ResponseEntity<MarketPlaceDto[]> rspey = restTemplate.getForEntity("https://my.api.mockaroo.com/marketplace?key=63304c70",MarketPlaceDto[].class);
        MarketPlaceDto[] marketPlaceArray = rspey.getBody();
        List<MarketPlaceDto> data = Arrays.asList(marketPlaceArray);
        marketPlaceService.createMarketPlace(data);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}

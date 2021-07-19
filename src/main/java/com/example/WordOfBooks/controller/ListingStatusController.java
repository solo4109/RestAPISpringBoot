package com.example.WordOfBooks.controller;

import com.example.WordOfBooks.domain.Listing;
import com.example.WordOfBooks.domain.ListingStatus;
import com.example.WordOfBooks.domain.Location;
import com.example.WordOfBooks.domain.dto.ListingDto;
import com.example.WordOfBooks.domain.dto.ListingStatusDto;
import com.example.WordOfBooks.service.ListingStatusService;
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
public class ListingStatusController {

    private final ListingStatusService listingStatusService;

    @Autowired
    public ListingStatusController(ListingStatusService listingStatusService) {
        this.listingStatusService = listingStatusService;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/listingStatus")
    public ResponseEntity<?> getListingStatus() {
        ResponseEntity<ListingStatusDto[]> rspey = restTemplate.getForEntity("https://my.api.mockaroo.com/listingStatus?key=63304c70",ListingStatusDto[].class);
        ListingStatusDto[] listingStatusArray = rspey.getBody();
        List<ListingStatusDto> data = Arrays.asList(listingStatusArray);
        this.listingStatusService.createListingStatus(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

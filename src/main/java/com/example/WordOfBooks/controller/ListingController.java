package com.example.WordOfBooks.controller;

import com.example.WordOfBooks.domain.Listing;
import com.example.WordOfBooks.domain.dto.ListingDto;
import com.example.WordOfBooks.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//a controller a másik API-tól fogadja az adatokat

//https://my.api.mockaroo.com/listing?key=63304c70

@RestController  //http hívásokat valahogy szervezi
//@RequestMapping("https://my.api.mockaroo.com") //ez is kell!!
public class ListingController {

    private final ListingService listingService;

    @Autowired // hogy a spring be tudja rakni a dependency injection-öket
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/listing", produces = "application/json") //fogadja a /listing-re jövö getet. a http protokol getje . Ez egy vég pont. Erről a címről fognak küldeni, és beállítottam, hogy erről a cimről fog jönni az addat.
    public ResponseEntity<?> getListing(){
        String requestJson = "{\"queriedQuestion\"😕\"Is there pain in your hand?\"}";
       // String quotes = "He said \"Hello, World!\"";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<ListingDto[]> rspey = restTemplate.exchange("https://my.api.mockaroo.com", HttpMethod.GET, entity, ListingDto[].class);
        ListingDto[] listingsArray = rspey.getBody(); //http body-ját
        List <ListingDto> data = Arrays.asList(listingsArray);
        this.listingService.createListing(data);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}

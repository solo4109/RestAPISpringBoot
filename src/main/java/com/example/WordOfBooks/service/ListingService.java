package com.example.WordOfBooks.service;

import com.example.WordOfBooks.domain.Listing;
import com.example.WordOfBooks.domain.dto.ListingDto;
import com.example.WordOfBooks.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListingService {

    private ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> createListing(List<ListingDto> listing){
//        Listing result = this.listingRepository.save(new Listing(listing));
        List <Listing> result = listing.stream().map(Listing::new).collect(Collectors.toList());
        return this.listingRepository.saveAll(result);
    }

}

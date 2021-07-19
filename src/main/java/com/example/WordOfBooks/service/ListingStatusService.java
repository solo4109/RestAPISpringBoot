package com.example.WordOfBooks.service;

import com.example.WordOfBooks.domain.ListingStatus;
import com.example.WordOfBooks.domain.Location;
import com.example.WordOfBooks.domain.dto.ListingStatusDto;
import com.example.WordOfBooks.domain.dto.LocationDto;
import com.example.WordOfBooks.repository.ListingStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListingStatusService {

    private ListingStatusRepository listingStatusRepository;

    @Autowired
    public ListingStatusService(ListingStatusRepository listingStatusRepository) {
        this.listingStatusRepository = listingStatusRepository;
    }

    public List<ListingStatus> createListingStatus(List<ListingStatusDto> listingStatus){
        List<ListingStatus> result = listingStatus.stream().map(ListingStatus::new).collect(Collectors.toList());
        return this.listingStatusRepository.saveAll(result);
    }
}

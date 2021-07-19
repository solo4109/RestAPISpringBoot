package com.example.WordOfBooks.service;

import com.example.WordOfBooks.domain.MarketPlace;
import com.example.WordOfBooks.domain.dto.MarketPlaceDto;
import com.example.WordOfBooks.repository.MarketPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MarketPlaceService {

    private MarketPlaceRepository marketPlaceRepository;

    @Autowired
    public MarketPlaceService(MarketPlaceRepository marketPlaceRepository) {
        this.marketPlaceRepository = marketPlaceRepository;
    }

    public List<MarketPlace> createMarketPlace(List<MarketPlaceDto> marketPlace){
        List<MarketPlace> result = marketPlace.stream().map(MarketPlace::new).collect(Collectors.toList());
        return this.marketPlaceRepository.saveAll(result);
    }
}

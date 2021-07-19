package com.example.WordOfBooks.repository;

import com.example.WordOfBooks.domain.MarketPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MarketPlaceRepository extends JpaRepository<MarketPlace, Long> {
}

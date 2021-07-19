package com.example.WordOfBooks.repository;

import com.example.WordOfBooks.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListingRepository extends JpaRepository <Listing, UUID> {

}

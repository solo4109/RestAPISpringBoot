package com.example.WordOfBooks.repository;

import com.example.WordOfBooks.domain.ListingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;


@Repository
public interface ListingStatusRepository extends JpaRepository<ListingStatus, Long> {
}

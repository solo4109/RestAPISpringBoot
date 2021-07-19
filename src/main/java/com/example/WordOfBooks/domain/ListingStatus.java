package com.example.WordOfBooks.domain;
import com.example.WordOfBooks.domain.dto.ListingStatusDto;
import com.sun.istack.NotNull;
import javax.persistence.*;


@Entity
public class ListingStatus {

    public ListingStatus() {
    }

    public ListingStatus(ListingStatusDto listingStatusDto){
        this.id = listingStatusDto.getId();
        this.statusName = listingStatusDto.getStatusName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Listing_status_id")
    private Long id;


    @Column(name = "Status_name")
    private String statusName;

}

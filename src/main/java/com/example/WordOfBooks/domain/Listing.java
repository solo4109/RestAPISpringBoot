package com.example.WordOfBooks.domain;

import com.example.WordOfBooks.domain.dto.ListingDto;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Listing {

    public Listing() {
    }

    public Listing(ListingDto listingDto ) {
        this.id = UUID.fromString(listingDto.getId());
        this.title = listingDto.getTitle();
        this.description = listingDto.getDescription();
        this.locationId = listingDto.getLocationId();
        this.listingPrice = listingDto.getListingPrice();
        this.currency = listingDto.getCurrency();
        this.quantity = listingDto.getQuantity();
        this.listingStatus = listingDto.getListingStatus();
        this.marketplace = listingDto.getMarketplace();
        this.ownerEmailAdress = listingDto.getOwnerEmailAddress();
    }

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "description")
    @NotNull
    private String description;


    @JoinColumn(name =  "location_id", referencedColumnName = "id")
    private UUID locationId;

    @Column(name = "listing_price" )
    @NotNull
    private Double listingPrice;

    @Column(name = "currency")
    @NotNull
    private String currency;

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;

    @Column(name = "listing_status")
    @JoinColumn(name = "Listing_status_id", referencedColumnName = "id")
    @NotNull
    private Integer listingStatus;

    @Column(name = "marketplace")
    @NotNull
    private String marketplace;

    @Column(name = "owner_email_address")
    @NotNull
    private String ownerEmailAdress;




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }


    // Integer helyett Double.

    public Double getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(Double listingPrice) {
        this.listingPrice = listingPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(Integer listingStatus) {
        this.listingStatus = listingStatus;
    }

    public String getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(String marketplace) {
        this.marketplace = marketplace;
    }

    public String getOwnerEmailAdress() {
        return ownerEmailAdress;
    }

    public void setOwnerEmailAdress(String ownerEmailAdress) {
        this.ownerEmailAdress = ownerEmailAdress;
    }
}



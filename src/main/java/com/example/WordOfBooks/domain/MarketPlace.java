package com.example.WordOfBooks.domain;

import com.example.WordOfBooks.domain.dto.MarketPlaceDto;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
public class MarketPlace {

    public  MarketPlace(){

    }

    public MarketPlace (MarketPlaceDto marketPlaceDto){
        this.id = marketPlaceDto.getId();
        this.marketPlaceName = marketPlaceDto.getMarketPlaceName();
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Listing_status_id")
    private Long id;

    @NotNull
    @Column(name ="Marketplace_name")
    private String marketPlaceName;

}

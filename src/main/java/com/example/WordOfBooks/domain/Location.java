package com.example.WordOfBooks.domain;

import com.example.WordOfBooks.domain.dto.LocationDto;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Location {

    public Location() {
    }

    public Location(LocationDto locationDto){
        this.id = locationDto.getId();
        this.managerName = locationDto.getManagerName();
        this.phone = locationDto.getPhone();
        this.addressPrimary = locationDto.getAddressPrimary();
        this.addressSecondary = locationDto.getAddressSecondary();
        this.country = locationDto.getCountry();
        this.town = locationDto.getTown();
        this.postalCode = locationDto.getPostalCode();
    }
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "Manager_name")
    @NotNull
    private String managerName;

    @Column(name = "Phone_number")
    @NotNull
    private String phone;

    @Column(name ="Primary_address")
    @NotNull
    private String addressPrimary;

    @Column(name ="Secondary_address")
    @NotNull
    private String addressSecondary;

    @Column(name ="Country")
    @NotNull
    private String country;

    @Column(name="Town")
    @NotNull
    private String town;

    @Column(name="Postal_Code")
    @NotNull
    private String postalCode;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressPrimary() {
        return addressPrimary;
    }

    public void setAddressPrimary(String addressPrimary) {
        this.addressPrimary = addressPrimary;
    }

    public String getAddressSecondary() {
        return addressSecondary;
    }

    public void setAddressSecondary(String addressSecondary) {
        this.addressSecondary = addressSecondary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }



}

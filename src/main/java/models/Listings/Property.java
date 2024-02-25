package models.Listings;

import models.Users.User;

import java.util.Date;

public abstract class Property {

    public enum Type {
        SINGLE_FAMILY_RESIDENCE,
        MOBILE_HOME,
        APARTMENT,
        STUDIO,
        OTHER
    }

    public enum PetPolicy {
        CATS,
        DOGS,
        SMALL_DOGS,
        NONE,
        CONTACT_HOST
    }

    public enum Parking {
        ATTACHED_GARAGE,
        DETACHED_GARAGE,
        DRIVEWAY,
        OFF_STREET
    }

    public enum Laundry {
        IN_UNIT,
        COMMUNAL,
        HOOKUPS,
        NONE
    }

    public enum Cooling {
        CENTRAL_AIR,
        EVAPORATIVE_COOLING,
        CEILING_FANS,
        OTHER,
        NONE
    }

    public enum Heating {
        FORCED_AIR,
        NATURAL_GAS,
        BASEBOARD,
        HEAT_PUMP,
        FIREPLACE,
        OTHER,
        NONE
    }

    private int rent;
    private User host;
    private String address;
    private Date dateBuilt;
    private Date dateAvailable;
    private Type propertyType;
    private Cooling cooling;
    private Heating heating;
    private PetPolicy petPolicy;
    private Parking parking;
    private Laundry laundry;
    private int deposit;

    // sets rent of property
    public void setRent(int rent) {
        this.rent = rent;
    }

    // returns rent of property
    public int getRent() {
        return this.rent;
    }

    // sets host of property
    public void setHost(User host) {
        this.host = host;
    }

    // returns host of property
    public User getHost() {
        return this.host;
    }

    // sets address of property
    public void setAddress(String address) {
        this.address = address;
    }

    // returns address of property
    public String getAddress() {
        return this.address;
    }

    // sets date property was built
    public void setDateBuilt(Date date) {
        this.dateBuilt = date;
    }

    // returns date property was built
    public Date getDateBuilt() {
        return this.dateBuilt;
    }

    // sets date property is available
    // for viewing/applications
    public void setDateAvailable(Date date) {
        this.dateAvailable = date;
    }

    // returns date property is available
    // for viewing/applications
    public Date getDateAvailable() {
        return this.dateAvailable;
    }

    // set type of residence
    public void setPropertyType(Type type){
        this.propertyType = type;
    }

    // return type of residence
    public Type getPropertyType() {
        return this.propertyType;
    }

    // sets Cooling type of property
    public void setCooling(Cooling cooling) {
        this.cooling = cooling;
    }

    // returns Cooling type of property
    public Cooling getCooling() {
        return this.cooling;
    }

    // sets Heating type of property
    public void setHeating(Heating heating) {
        this.heating = heating;
    }

    // returns Heating type of property
    public Heating getHeating() {
        return this.heating;
    }

    // sets PetPolicy of property
    public void setPetPolicy(PetPolicy policy) {
        this.petPolicy = policy;
    }

    // returns PetPolicy of property
    public PetPolicy getPetPolicy() {
        return this.petPolicy;
    }

    // sets Parking type of property
    public void setParking(Parking parking) {
        this.parking = parking;
    }

    // returns Parking type for property
    public Parking getParking() {
        return this.parking;
    }

    // sets Laundry type for property
    public void setLaundry(Laundry laundry) {
        this.laundry = laundry;
    }

    // returns Laundry type of property
    public Laundry getLaundry() {
        return this.laundry;
    }

    // sets deposit for property
    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    // returns deposit for property
    public int getDeposit() {
        return this.deposit;
    }
}

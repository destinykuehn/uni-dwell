package models.Listings;

import models.Users.Review;
import models.Users.User;

import java.util.ArrayList;

public class Listing extends Property {
    private House house;
    private boolean isHouse;
    private boolean isRoom;
    private Room room;
    private boolean visible = true;
    private ArrayList<User> favoriteByList;
    private ArrayList<Review> reviewList;

    public Listing() {

    }

    // listing of type House
    public Listing(House house) {
        this.house = house;
        this.isHouse = true;
        this.isRoom = false;
        this.favoriteByList = new ArrayList<User>();
        this.reviewList = new ArrayList<Review>();
    }

    // listing of type Room
    public Listing(Room room) {
        this.room = room;
        this.isRoom = true;
        this.isHouse = false;
        this.favoriteByList = new ArrayList<User>();
        this.reviewList = new ArrayList<Review>();
    }

    // returns true if listing is a house
    // returns false if listing is a room
    public boolean isHouse() {
        return this.isHouse;
    }

    // returns true if listing is a room
    // returns false if listing is a house
    public boolean isRoom() {
        return this.isRoom;
    }

    // get house instance from
    // house listing
    public House getHouse() {
        return this.house;
    }

    // get room instance from
    // room listing
    public Room getRoom() {
        return this.room;
    }

    // set whether listing is visible or hidden
    // in searches
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    // returns true if listing is visible in search
    // returns false if host has hidden it
    public boolean isVisible() {
        return this.visible;
    }

    // student has added listing to their favorites list
    // student/host has removed listing from favorites list
    // listing has been closed and therefore removed
    public void updateFavoriteByList(String action, User user) {
        switch(action){
            case "add":
                this.favoriteByList.add(user);
                break;
            case "delete":
                this.favoriteByList.remove(user);
                break;
        }
    }

    public void addReview(Review review) {
        this.reviewList.add(review);
    }

    public void removeReview(Review review) {
        this.reviewList.remove(review);
    }
}

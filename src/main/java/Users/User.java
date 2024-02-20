package Users;

import Listings.Listing;

import java.util.ArrayList;

public class User {

    private String profilePic;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Reputation reputation;
    private ArrayList<Review> reviewList;
    protected Role role;
    private Chat chat;

    public enum Role {
        STUDENT {
            private ArrayList<Listing> favoriteListingsList;

            @Override
            public void addListing(Listing listing) {
                this.favoriteListingsList.add(listing);
            }

            @Override
            public void removeListing(Listing listing) {
                this.favoriteListingsList.remove(listing);
            }

            @Override
            public ArrayList<Listing> getListing(){
                return this.favoriteListingsList;
            }
        },
        HOST {
            private ArrayList<Listing> listingList;

            @Override
            public void addListing(Listing listing){
                this.listingList.add(listing);
            }

            @Override
            public void removeListing(Listing listing){
                this.listingList.remove(listing);
            }

            @Override
            public ArrayList<Listing> getListing(){
                return this.listingList;
            }
        };

        public abstract void addListing(Listing listing);
        public abstract void removeListing(Listing listing);
        public abstract ArrayList<Listing> getListing();
    }

    public User(Role role) {
        this.role = role;
        this.reputation = new Reputation();
        this.chat = new Chat();
    }

    public Role getRole() {
        return this.role;
    }

    public void setProfilePicture(String picture) {
        this.profilePic = picture;
    }

    public String getProfilePicture() {
        return this.profilePic;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setReputation(Reputation reputation) {
        this.reputation = reputation;
    }

    public Reputation getReputation() {
        return this.reputation;
    }

    public void updateReviews(String action, Review review) {
        switch(action) {
            case "add":
                break;
            case "remove":
                break;
        }
    }

    public ArrayList<Review> getReviews() {
        return this.reviewList;
    }

    public Chat getChat() {
        return this.chat;
    }
}

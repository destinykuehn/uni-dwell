package Users;

import Listings.Listing;
import Users.User;

import java.math.BigDecimal;

public class Review {

    private User reviewee;
    private User reviewer;
    private Listing listing;
    private BigDecimal starRating;
    private String text;

    public Review() {

    }

    public Review(User reviewer, User reviewee, BigDecimal starRating, String text) {
        this.reviewer = reviewer;
        this.reviewee = reviewee;
        this.starRating = starRating;
        this.text = text;
    }

    public Review(Listing listing, User reviewer, User reviewee, BigDecimal starRating, String text) {
        this.listing = listing;
        this.reviewer = reviewer;
        this.reviewee = reviewee;
        this.starRating = starRating;
        this.text = text;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Listing getListing() {
        return this.listing;
    }

    public void setReviewee(User user) {
        this.reviewee = user;
    }

    public User getReviewee() {
        return this.reviewee;
    }

    public void setReviewer(User user) {
        this.reviewer = user;
    }

    public User setReviewer() {
        return this.reviewer;
    }

    public void setStarRating(BigDecimal rating) {
        this.starRating = rating;
    }

    public BigDecimal getStarRating() {
        return this.starRating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}

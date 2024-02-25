package models.Users;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Reputation {

    private BigDecimal starRating;
    private ArrayList<Review> reviewList;

    public Reputation() {
        this.starRating = new BigDecimal("0.0");
        this.reviewList = new ArrayList<Review>();
    }

    public void getStarRating() {
        BigDecimal rating = new BigDecimal("0.0");
        for (Review r : reviewList) {
            rating = rating.add(r.getStarRating());
        }
        this.starRating = rating;
    }

    public void addReview(Review review) {
        this.reviewList.add(review);
    }

    public void removeReview(Review review) {
        this.reviewList.remove(review);
    }

    public ArrayList<Review> getReviewList() {
        return this.reviewList;
    }
}

package com.embarkx.jobapp.review;
import java.util.List;
import com.embarkx.jobapp.company.Company;


public interface ReviewService {

    List<Review> findAll();
    void createNew(Review review);
    Review getReviewById(Long id);
    boolean deleteReviewById(Long id);
    boolean editReview(Review review);
    public List<Review> findReviewsByCompany(Company company);
}

package com.embarkx.jobapp.review.impl;

import com.embarkx.jobapp.review.Review;
import com.embarkx.jobapp.review.ReviewRepository;
import com.embarkx.jobapp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void createNew(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
        return reviewRepository.findById(id).isPresent();
    }

    @Override
    public boolean editReview(Review _review) {

        Optional<Review> reviewOpt = reviewRepository.findById(_review.getId());
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            review.setDescription(_review.getDescription());
            review.setTitle(_review.getTitle());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

//    @Override
//    public List<Review> findReviewsByCompany(Company company) {
//      return reviewRepository.findAllByCompany(company);
//    }

}

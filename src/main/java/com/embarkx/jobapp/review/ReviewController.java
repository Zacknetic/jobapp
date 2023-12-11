package com.embarkx.jobapp.review;

import com.embarkx.jobapp.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@RestController
public class ReviewController {

    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService _reviewService) {
        reviewService = _reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll() {
        List<Review> reviews = reviewService.findAll();
        if (reviews.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reviews, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        reviewService.createNew(review);
        return new ResponseEntity<>("Review added successfully.", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReviewById(@PathVariable Long id) {
        if (!reviewService.deleteReviewById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<Boolean> editReviewById( @RequestBody Review review) {

        if(!reviewService.editReview(review)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
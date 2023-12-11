package com.embarkx.jobapp.company;

import com.embarkx.jobapp.review.ReviewService;
import com.embarkx.jobapp.review.Review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/companies")
@RestController
public class CompanyController {


    @Autowired
    private final CompanyService companyService;

    @Autowired
    private final ReviewService reviewService;
    public CompanyController(CompanyService _companyService, ReviewService _reviewService) {
        companyService = _companyService;
        reviewService = _reviewService;
    }

    //company mappings start
    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        List<Company> companies = companyService.findAll();
        if (companies.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(companies, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createNew(company);
        return new ResponseEntity<>("Company added successfully.", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCompanyById(@PathVariable Long id) {
        if (!companyService.deleteCompanyById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<Boolean> editCompanyById( @RequestBody Company company) {

        if(!companyService.editCompany(company)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    //company mappings end

    //reviews mappings start
    @GetMapping("/{companyId}/reviews")
    public ResponseEntity<List<Review>> findAllCompanyReviews(@PathVariable Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        List<Review> reviews = reviewService.findReviewsByCompany(company);
        if (reviews.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deleteCompanyById(@PathVariable Long id) {
//        if (!companyService.deleteCompanyById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }
//
//    @PutMapping
//    public  ResponseEntity<Boolean> editCompanyById( @RequestBody Company company) {
//
//        if(!companyService.editCompany(company)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }

    //reviews mappings end
}
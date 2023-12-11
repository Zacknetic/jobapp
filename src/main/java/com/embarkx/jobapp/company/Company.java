package com.embarkx.jobapp.company;

import com.embarkx.jobapp.job.Job;
import com.embarkx.jobapp.review.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "title", length = 100, nullable = false, unique = true)
    private String title;

    @NonNull
    @Column(name = "description", length = 1000, nullable = false, unique = true)
    private String description;

    @NonNull
    @Column(name = "location", length = 1000, nullable = false, unique = true)
    private String location;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "company_reviews", joinColumns = {@JoinColumn(name = "company_id")}, inverseJoinColumns = {@JoinColumn(name = "review_id")})
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "company_jobs", joinColumns = {@JoinColumn(name = "company_id")}, inverseJoinColumns = {@JoinColumn(name = "job_id")})
    private Set<Job> jobs = new HashSet<>();

}

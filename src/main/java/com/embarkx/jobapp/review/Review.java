package com.embarkx.jobapp.review;

import com.embarkx.jobapp.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @NonNull
    @Column(name = "description", length = 1000, nullable = false)
    private String description;

    @NonNull
    @Column(name = "rating", length = 10, nullable = false)
    private double rating;

    @ManyToOne
    private Company company;

}

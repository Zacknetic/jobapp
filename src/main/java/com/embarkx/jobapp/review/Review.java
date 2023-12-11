package com.embarkx.jobapp.review;

import com.embarkx.jobapp.company.Company;
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
    @Column(name = "title", length = 100, nullable = false, unique = true)
    private String title;

    @NonNull
    @Column(name = "description", length = 1000, nullable = false, unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false)
    private Company company;

}

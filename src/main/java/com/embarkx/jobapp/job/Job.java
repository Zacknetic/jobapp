package com.embarkx.jobapp.job;

import com.embarkx.jobapp.company.Company;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {

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
    @Column(name = "minSalary", length = 1000, nullable = false, unique = true)
    private String minSalary;

    @NonNull
    @Column(name = "maxSalary", length = 1000, nullable = false, unique = true)
    private String maxSalary;

    @NonNull
    @Column(name = "location", length = 1000, nullable = false, unique = true)
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false)
    private Company company;

}

package com.embarkx.jobapp.company;

import jakarta.persistence.*;
import lombok.*;

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

}

package com.embarkx.jobapp.review;

import com.embarkx.jobapp.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, JpaSpecificationExecutor<Company> {
    List<Review> findAllByCompanyId(Long companyId);
}

package com.embarkx.jobapp.company;

import java.util.List;


public interface CompanyService {

    List<Company> findAll();
    void createNew(Company company);
    Company getCompanyById(Long id);
    boolean deleteCompanyById(Long id);
    boolean editCompany(Company company);
}

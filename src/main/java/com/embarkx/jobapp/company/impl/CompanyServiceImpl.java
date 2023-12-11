package com.embarkx.jobapp.company.impl;
import java.util.List;
import java.util.Optional;

import com.embarkx.jobapp.company.Company;
import com.embarkx.jobapp.company.CompanyRepository;
import com.embarkx.jobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createNew(Company company) {
//        Company newCompany = new Company(company);
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
        return companyRepository.findById(id).isEmpty();
    }

    @Override
    public boolean editCompany(Company _company) {

        Optional<Company> companyOpt = companyRepository.findById(_company.getId());
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            company.setDescription(_company.getDescription());
            company.setLocation(_company.getLocation());
            company.setTitle(_company.getTitle());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

}

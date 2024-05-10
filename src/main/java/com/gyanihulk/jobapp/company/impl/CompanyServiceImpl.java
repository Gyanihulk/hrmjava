package com.gyanihulk.jobapp.company.impl;

import com.gyanihulk.jobapp.company.Company;
import com.gyanihulk.jobapp.company.CompanyRepository;
import com.gyanihulk.jobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company companyDetails) {
        Company company = findById(id);
        if (company != null) {
            company.setName(companyDetails.getName());
            company.setDescription(companyDetails.getDescription());
            company.setJobs((companyDetails.getJobs()));
            return companyRepository.save(company);
        }
        // Handle the case where the company doesn't exist or throw an exception
        return null;
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }
}

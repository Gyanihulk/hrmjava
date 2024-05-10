package com.gyanihulk.jobapp.company;

import java.util.List;

public interface CompanyService {
    Company findById(Long id);
    Company saveCompany(Company company);
    Company updateCompany(Long id, Company companyDetails);
    boolean deleteCompany(Long id);
    List<Company> findAllCompanies();
}
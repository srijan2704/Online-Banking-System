package com.isb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.entity.Beneficiary;
import com.isb.repository.BeneficiaryRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

@Autowired
private BeneficiaryRepository beneficiaryRepository;

@Override
public String AddBeneficiaryService(Beneficiary beneficiary) {
    if (beneficiaryRepository.isValidBeneficiaryAccount(beneficiary.getCustomerId(),beneficiary.getBeneficiaryAccountNo())) 
    {
        if (beneficiaryRepository.isBeneficiaryAvailable(beneficiary.getCustomerId(),beneficiary.getBeneficiaryAccountNo()))
        {
            return "Beneficiary exists";
            
        } 
        else {
            beneficiaryRepository.AddBeneficiary(beneficiary);
            return "Beneficiary Added Succesfully";
        }
    } else {
        return "Beneficiary Not Valid!";
    }
}

@Override
public List<Beneficiary> getBeneficiaryService(long customerId) {
    List<Beneficiary> beneficiaryList = beneficiaryRepository.getBeneficiaryRepository(customerId);
    return beneficiaryList;
}
}
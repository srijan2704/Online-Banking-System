package com.isb.service;

import java.util.List;

import com.isb.entity.Beneficiary;

public interface BeneficiaryService {

public String AddBeneficiaryService(Beneficiary beneficiary);
public List<Beneficiary> getBeneficiaryService(long customerId);
}
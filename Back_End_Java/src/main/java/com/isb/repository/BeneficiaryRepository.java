package com.isb.repository;

import java.util.List;

import com.isb.entity.Beneficiary;

public interface BeneficiaryRepository {
	public boolean isBeneficiaryAvailable(long customerId, long beneficiaryAccountNumber);
	public boolean isValidBeneficiaryAccount(long customerId , long beneficiaryAccountNumber);
	public void AddBeneficiary(Beneficiary beneficiary);
	public List<Beneficiary> getBeneficiaryRepository(long customerId);
	
}

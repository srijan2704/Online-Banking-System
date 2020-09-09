package com.isb.repository;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isb.entity.Beneficiary;

@Repository
public class BeneficiaryRepositoryImpl  implements BeneficiaryRepository {

@PersistenceContext
private EntityManager entityManager;


@Transactional
public void AddBeneficiary(Beneficiary beneficiary) {
    
    entityManager.merge(beneficiary);
    
}


public boolean isBeneficiaryAvailable(long customerId, long beneficiaryAccountNumber) {
    try {
     entityManager.createNativeQuery("select beneficiary_account_no from tb1_beneficiary where customer_id=:cid and beneficiary_account_no=:acc ")
    .setParameter("cid", customerId)
    .setParameter("acc", beneficiaryAccountNumber)
    .getSingleResult() ;
    return true;
    }
    catch(Exception e) {
        return false;
    }
}

public boolean isValidBeneficiaryAccount(long customerId , long beneficiaryAccountNumber) {
    try {
         entityManager.createNativeQuery("select account_no from tb1_account where account_no=:acc and customer_id!=:cid")
        .setParameter("cid", customerId)
        .setParameter("acc", beneficiaryAccountNumber)
        .getSingleResult() ;
        return true;
        }
        catch(Exception e) {
            return false;
        }
}


public List<Beneficiary> getBeneficiaryRepository(long customerId){
    return  (List<Beneficiary>)entityManager
            .createQuery("select be from Beneficiary be where be.customerId=:cid")
            .setParameter("cid", customerId)
            .getResultList();
}
}
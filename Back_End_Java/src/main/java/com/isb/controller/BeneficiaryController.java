package com.isb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.AddBeneficiaryError;
import com.isb.dto.BeneficiaryDto;
import com.isb.dto.CustomerIdDto;
import com.isb.entity.Beneficiary;
import com.isb.service.BeneficiaryService;

@RestController
@CrossOrigin
public class BeneficiaryController {

@Autowired
private BeneficiaryService beneficiaryService;

@PostMapping("/addBeneficiary")
public AddBeneficiaryError BeneficiaryRegister(@RequestBody Beneficiary beneficiary ) {
    System.out.println(beneficiary); 
    try
    {
        AddBeneficiaryError message = new AddBeneficiaryError();
        message.setMessage(beneficiaryService.AddBeneficiaryService(beneficiary));
        return message;
    }
    catch(Exception e)
    {
    	AddBeneficiaryError message = new AddBeneficiaryError();
    	message.setMessage(beneficiaryService.AddBeneficiaryService(beneficiary));
    	return message;
    }
}

@PostMapping("/getBeneficiaryList")
public List<Beneficiary> getBeneficiaryForCustomer(@RequestBody CustomerIdDto customerIdDto){
    List<Beneficiary> beneficieries = beneficiaryService.getBeneficiaryService(customerIdDto.getCustomerId());
    return beneficieries;
}
}


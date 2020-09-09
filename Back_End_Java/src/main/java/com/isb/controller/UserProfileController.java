package com.isb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.CustomerIdDto;
import com.isb.dto.UserProfileDto;
import com.isb.entity.Customer;
import com.isb.service.UserProfileService;

@RestController
@CrossOrigin
public class UserProfileController {
	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping(path = "/userProfile", method = RequestMethod.POST,  produces = "application/json")

    public UserProfileDto UserProfileController(@RequestBody CustomerIdDto customerIdDto){
    Customer customer = new Customer();

        UserProfileDto userProfileDto = new UserProfileDto();

        customer = userProfileService.UserProfileService(customerIdDto.getCustomerId());

        BeanUtils.copyProperties(customer,userProfileDto);

        return userProfileDto;

        }
}

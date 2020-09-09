package com.isb.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.AccountSummaryDto;
import com.isb.dto.CustomerIdDto;
import com.isb.entity.Account;
import com.isb.service.AccountSummaryService;

@RestController
@CrossOrigin
public class AccountSummaryController {
	
	@Autowired
	private AccountSummaryService accountSummaryService;
	
	@PostMapping("/accountSummary")
	public AccountSummaryDto accountSummaryController(@RequestBody CustomerIdDto customerIdDto)
	{
		 Account account = new Account();

         AccountSummaryDto accountSummaryDto = new AccountSummaryDto();

         account = accountSummaryService.accountSummary(customerIdDto.getCustomerId());

         BeanUtils.copyProperties(account,accountSummaryDto);

         return accountSummaryDto;
	}
}

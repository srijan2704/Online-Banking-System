package com.isb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isb.dto.PasswordDto;
import com.isb.dto.CheckOtpDto;
import com.isb.dto.DashPasswordDto;
import com.isb.dto.IdCheckDto;
import com.isb.dto.ResetStatus;
import com.isb.dto.Status;
import com.isb.dto.Status.StatusType;
import com.isb.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	long rememberId;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/setPaaswordLink")
	public ResetStatus resetPassword(@RequestBody PasswordDto passwordDto) {
		try {
			customerService.resetPassword(rememberId, passwordDto.getPassword());
			ResetStatus resetStatus = new ResetStatus();
			resetStatus.setStatus(StatusType.Success);
			resetStatus.setMessage("Password Reset Successful");
			return resetStatus;
		}

		catch (Exception e) {
			ResetStatus resetStatus = new ResetStatus();
			resetStatus.setStatus(StatusType.Failure);
			resetStatus.setMessage("Password Reset Failed. Kindly Check the details entered. ");
			return resetStatus;
		}
	}

	@PostMapping("/forgetPasswordLink")
	public Status preResetCheck(@RequestBody IdCheckDto idCheckDto) {
		if (customerService.preResetCheck(idCheckDto.getCustomerId())) {
			System.out.println("back from service to controller");
			rememberId = idCheckDto.getCustomerId();
			Status status = new Status();
			status.setStatus(StatusType.Success);
			return status;
		}

		Status status = new Status();
		status.setStatus(StatusType.Failure);
		return status;
	}

	@PostMapping("/checkotp")
	public Status validateOtp(@RequestBody CheckOtpDto checkOtpDto) {
		if (customerService.validateOtp(checkOtpDto.getOtp())) {
			System.out.println("back from service to controller");
			Status status = new Status();
			status.setStatus(StatusType.Success);
			return status;
		}

		Status status = new Status();
		status.setStatus(StatusType.Failure);
		return status;
	}
	
	@PostMapping("/dashSetPaaswordLink")
	public ResetStatus dashBoardresetPassword(@RequestBody DashPasswordDto dashpasswordDto) {
		try {
			customerService.dashBoardresetPassword(dashpasswordDto.getCustomerId(), dashpasswordDto.getLoginPassword(), dashpasswordDto.getTransPassword());
			ResetStatus resetStatus = new ResetStatus();
			resetStatus.setStatus(StatusType.Success);
			resetStatus.setMessage("Password Reset Successful");
			return resetStatus;
		}

		catch (Exception e) {
			ResetStatus resetStatus = new ResetStatus();
			resetStatus.setStatus(StatusType.Failure);
			resetStatus.setMessage("Password Reset Failed. Kindly Check the details entered. ");
			return resetStatus;
		}
	}

}

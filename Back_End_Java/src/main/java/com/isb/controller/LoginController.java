package com.isb.controller;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.isb.controller.LoginController.Status.StatusType;
import com.isb.dto.AdminLoginDto;
import com.isb.dto.LoginDto;
import com.isb.entity.Admin;
import com.isb.entity.Customer;
import com.isb.exception.LoginServiceException;
import com.isb.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginService;

	HttpSession session;
	
	@PostMapping("/loginAdmin")
	public AdminLoginStatus loginAdmin(@RequestBody AdminLoginDto adminLoginDto) {
		try {
			Admin admin = loginService.loginAdmin(adminLoginDto.getAdminId(), adminLoginDto.getAdminPassword());
			AdminLoginStatus adminLoginStatus = new AdminLoginStatus();
			adminLoginStatus.setAdminId(admin.getAdminId());
			adminLoginStatus.setAdminName(admin.getAdminName());
			adminLoginStatus.setStatus(StatusType.SUCCESS);
			adminLoginStatus.setMessage("Admin Login Sucess");
			return adminLoginStatus;
		} catch (LoginServiceException e) {
			AdminLoginStatus adminLoginStatus = new AdminLoginStatus();
			adminLoginStatus.setStatus(StatusType.FAILURE);
			adminLoginStatus.setMessage(e.getMessage());
			return adminLoginStatus;
		}
	}

	@PostMapping("/login")
	public loginStatus login(@RequestBody LoginDto loginDto) {
		try {
			String password = Base64.getEncoder().encodeToString(loginDto.getLoginPassword().getBytes());
			Customer customer = loginService.login(loginDto.getCustomerId(), password);
			loginStatus loginstatus = new loginStatus();
			loginstatus.setCustomerFirstName(customer.getFirstName());
			loginstatus.setCustomerId(customer.getCustomerId());
			loginstatus.setStatus(StatusType.SUCCESS);
			loginstatus.setMessage("Success");
			/*
			 * session.setAttribute("Customer Id",
			 * String.valueOf(customer.getCustomerId()));
			 * session.setMaxInactiveInterval(600);
			 */
			return loginstatus;
		} catch (LoginServiceException e) {
			loginStatus loginstatus = new loginStatus();
			loginstatus.setStatus(StatusType.FAILURE);
			loginstatus.setMessage("incorrect password");
			return loginstatus;
		}
	}
	
	public static class AdminLoginStatus extends Status {

		public String adminName;
		public long adminId;
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		public long getAdminId() {
			return adminId;
		}
		public void setAdminId(long adminId) {
			this.adminId = adminId;
		}

		
	}


	public static class loginStatus extends Status {

		public String customerFirstName;
		public long customerId;

		public String getCustomerFirstName() {
			return customerFirstName;
		}

		public void setCustomerFirstName(String customerFirstName) {
			this.customerFirstName = customerFirstName;
		}

		public long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}

	}

	public static class Status {
		private StatusType status;
		private String message;

		public static enum StatusType {
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}

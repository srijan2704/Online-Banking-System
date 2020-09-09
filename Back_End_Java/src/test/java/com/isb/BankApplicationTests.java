package com.isb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.isb.entity.Customer;
import com.isb.repository.LoginRepository;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	public LoginRepository loginRepository;
	
	@Test
	public void getCustomerById()
	{
		System.out.println(loginRepository.findCustomerById(102));
	}
	
	@Test
	public void fetchByCustomerIdPassword()
	{
		long customerId = loginRepository.findCustomerByIdPassword(101, "Rishabh123");
		System.out.println(""+customerId);
	}
	
	@Test
	public void fetchByAdminId()
	{
		System.out.println(loginRepository.findAdminById(7002));
	}
	
	@Test
	public void fetchAdminByIdPassword()
	{
		long adminId = loginRepository.findAdminByIdPassword(7002,"admin123");
		System.out.println(adminId);
	}
}

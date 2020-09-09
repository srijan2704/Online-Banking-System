package com.isb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isb.dto.VisitorRegisterDto;
import com.isb.entity.Visitor;
import com.isb.exception.VisitorServiceException;
import com.isb.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorRepository repo;

	@Autowired
	private SendEmail sendEmail;

	@Override
	@Transactional
	public String addVisitor(Visitor visitor) {
		try {
			repo.addVisitor(visitor);
			long referenceNo = repo.findVisitorByAadhar(visitor.getAadharNo());
			String info = "Congratulations, you have been registered successfully. Your Service Reference Number is "
					+ referenceNo;
			System.out.println(referenceNo);
			String email = visitor.getEmail();
			// mail to be triggered (body -- congratulation, registered successfully and
			// refno (reqd text))//
			//////////////////////////////////
			sendEmail.Mailer(email, info);
			return "visitor added successfully";
		} catch (VisitorServiceException e) {
			return e.getMessage();
		}
	}

	@Override
	public String checkVisitorStatus(long service_ref_no) {
		try {
			return repo.checkVisitorStatus(service_ref_no);
		} catch (VisitorServiceException e) {
			return e.getMessage();
		}
	}

	@Override
	public Visitor getVisitor(long service_ref_no) {
		return repo.getVisitor(service_ref_no);
	}

	@Override
	@Transactional
	public void setVisitorStatus(long service_ref_no, String status) {
		repo.setVisitorStatus(service_ref_no, status);
	}

	@Override
	@Transactional
	public void deleteVisitor(long service_ref_no) {
		repo.deleteVisitor(service_ref_no);
	}

	@Override
	public long getRegionId(String city, String pinCode, String state) {
		return repo.getRegionId(city, pinCode, state);
	}

	@Override
	public List<Visitor> getVisitorByStatus(String status) {
		return repo.getVisitorByStatus(status);

	}

	@Override
	public List<Visitor> getVisitors() {
		return repo.getVisitors();

	}

}

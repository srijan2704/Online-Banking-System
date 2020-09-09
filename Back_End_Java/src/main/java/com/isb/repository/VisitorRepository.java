package com.isb.repository;

import java.util.List;

import com.isb.entity.Region;
import com.isb.entity.Visitor;

public interface VisitorRepository {
	
	public String addVisitor(Visitor visitor);
	
	public String checkVisitorStatus(long service_ref_no);
	
	public void setVisitorStatus(long service_ref_no , String status);
	
	public Visitor getVisitor(long service_ref_no);
	
	public void deleteVisitor(long service_ref_no);
	
	public long getRegionId(String city , String pinCode , String state);
	
	public List<Visitor> getVisitorByStatus(String status);

	public List<Visitor> getVisitors() ;
	
	public long findVisitorByAadhar(String aadhar);
}

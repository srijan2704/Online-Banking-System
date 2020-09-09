package com.isb.service;

import java.util.List;

import com.isb.entity.Visitor;

public interface VisitorService {

	public String addVisitor(Visitor visitor);
	
	public String checkVisitorStatus(long service_ref_no);
	
	public Visitor getVisitor(long service_ref_no);
	
	public void setVisitorStatus(long service_ref_no , String status);
	
	public void deleteVisitor(long service_ref_no);
	
	public long getRegionId(String city , String pinCode , String state);
	
	public List<Visitor> getVisitorByStatus(String status);
	
	public List<Visitor> getVisitors() ;
}

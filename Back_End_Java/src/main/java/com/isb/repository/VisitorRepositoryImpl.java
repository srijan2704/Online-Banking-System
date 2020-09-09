package com.isb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isb.entity.Region;
import com.isb.entity.Visitor;
import com.isb.exception.VisitorServiceException;

@Repository
public class VisitorRepositoryImpl implements VisitorRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String addVisitor(Visitor visitor) {
		try {
		em.merge(visitor);
		return "Registration Successful!";
		}
		catch(VisitorServiceException e)
		{
			throw new VisitorServiceException("Registration Failed!");
		}
	}

	@Override
	public String checkVisitorStatus(long service_ref_no) {
		try {
		return em
				.find(Visitor.class, service_ref_no)
				.getStatus().toString();
		}
		catch(VisitorServiceException e)
		{
			throw new VisitorServiceException("Not Found!");
		}
	}
	
	@Override
	public void setVisitorStatus(long service_ref_no , String status)
	{
		em
		.createNativeQuery("UPDATE tb1_visitors SET status=:st WHERE service_ref_no=:srn")
		.setParameter("st", status)
		.setParameter("srn", service_ref_no)
		.executeUpdate();
	}

	@Override
	public Visitor getVisitor(long service_ref_no) {
		return em.find(Visitor.class, service_ref_no);
	}

	@Override
	public void deleteVisitor(long service_ref_no) {
		 em.remove(em.find(Visitor.class, service_ref_no));
	}

	@Override
	public long getRegionId(String city, String pinCode, String state) {
		return (Long)em
				.createQuery("SELECT r.regionId FROM Region r WHERE r.city=:ct AND r.pincode=:pn AND r.state=:st")
				.setParameter("ct", city)
				.setParameter("pn", pinCode)
				.setParameter("st", state)
				.getSingleResult();
	}

	@Override
	public List<Visitor> getVisitors() {
		return em.createQuery("select v from Visitor v order by v.serviceRefNo")
				.getResultList();
		
	}
	
	@Override
	public List<Visitor> getVisitorByStatus(String status) {
		Query qry=em.createQuery("select v from Visitor v where v.status=:st");
		qry.setParameter("st", status);
		List<Visitor> visitors=qry.getResultList();
		return visitors;

}

	@Override
	public long findVisitorByAadhar(String aadhar) {
		List<Long> serviceRefNos=(List<Long>) 
		em.createQuery("select v.serviceRefNo from Visitor v where v.aadharNo=:ad order by v.serviceRefNo")
		.setParameter("ad", aadhar).getResultList();
		return serviceRefNos.get(serviceRefNos.size() - 1);
	}
}

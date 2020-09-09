package com.isb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class GenericRepository implements Generic{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void add(Object obj) {
			entityManager.merge(obj);
	}
	
	@Override
	public Object fetch(Class clazz, Object pk) {
			Object emp = entityManager.find(clazz, pk);
			return emp;
			
		} 
	
	@Override
	@Transactional
	public void remove(Object obj)
	{
		entityManager.remove(obj);
	}
}

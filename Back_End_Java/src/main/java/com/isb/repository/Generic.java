package com.isb.repository;

public interface Generic {

	public void add(Object obj);
	
	public Object fetch(Class clazz, Object pk);
	
	public void remove(Object obj);
}

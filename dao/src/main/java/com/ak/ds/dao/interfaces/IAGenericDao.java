package com.ak.ds.dao.interfaces;

import java.util.List;

import com.ak.ds.entities.AEntity;

public interface IAGenericDao<T extends AEntity> {
	
	Class<T> getGenericClass();
	
	T add(T entity);
	
	T get(Long id);
	
	void update (T entity);
	
	void remove (Long id);
	
	List<T> getAll();

}

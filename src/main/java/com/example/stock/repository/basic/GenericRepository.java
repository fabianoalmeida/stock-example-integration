package com.example.stock.repository.basic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.stock.domain.BaseEntity;

/**
 * @author fabiano.barreto
 *
 */
public abstract class GenericRepository< T extends BaseEntity > implements BasicRepository< T > {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Class< T > clazz;
	
	@SuppressWarnings("unchecked")
	public GenericRepository() {
		this.clazz = ( Class< T > ) ( ( ParameterizedType ) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
	}
	
	public T add( T entity ) {
		
		T beanAdded = entityManager.merge( entity );
		
		return beanAdded;
	}

	public T find( Long id ) {
		
		T entity = entityManager.find( clazz, id );
		
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		
		Query query = entityManager.createQuery( "FROM " + clazz.getSimpleName() );
		
		List<T> resultList = query.getResultList();
		
		return resultList;
	}

	public T remove( Long id ) {
		
		T entity = find( id );
		
		T removed = null;
		
		if ( entity != null ) {

			removed = entityManager.merge( entity );
		}
		
		return removed;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}

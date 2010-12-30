package com.example.stock.repository.basic;

import java.util.List;

import com.example.stock.domain.BaseEntity;

/**
 * @author fabiano.barreto
 *
 */
public interface BasicRepository< T extends BaseEntity > {

	T remove( Long id );

	T add( T bean );

	T find( Long id );

	List< T > findAll();
	
}

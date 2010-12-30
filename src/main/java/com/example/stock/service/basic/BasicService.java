package com.example.stock.service.basic;

import java.util.List;

import com.example.stock.view.BaseDTO;

/**
 * @author fabiano.barreto
 *
 */
public interface BasicService< T extends BaseDTO > {

	T delete( Long id );

	T save( T bean );

	T find( Long id );

	List< T > findAll();
	
}

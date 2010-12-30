package com.example.stock.repository.impl;

import org.springframework.stereotype.Repository;

import com.example.stock.domain.entity.Unit;
import com.example.stock.repository.UnitRepository;
import com.example.stock.repository.basic.GenericRepository;

/**
 * @author fabiano.barreto
 *
 */
@Repository( "unitRepository" )
public class UnitRepositoryImpl extends GenericRepository< Unit > implements UnitRepository {

}

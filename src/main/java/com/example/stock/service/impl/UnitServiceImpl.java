package com.example.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stock.domain.entity.Unit;
import com.example.stock.repository.UnitRepository;
import com.example.stock.service.UnitService;
import com.example.stock.view.dto.UnitDTO;
import com.example.stock.view.dto.internal.UnitDTOAssembler;

/**
 * @author fabiano.barreto
 *
 */
@Service( "unitService" )
public class UnitServiceImpl implements UnitService {

	private UnitRepository unitRepository;
	
	@Autowired
	public UnitServiceImpl( @Qualifier( "unitRepository" ) UnitRepository unitRepository ) {
		this.unitRepository = unitRepository;
	}
	
	@Override
	@Transactional
	public UnitDTO delete( Long id ) {
		
		if ( id == null ) {
			throw new IllegalArgumentException();
		}
		
		Unit unitRemoved = unitRepository.remove( id );
		
		UnitDTO unitDTORemoved = null;
		
		if ( unitRemoved != null ) {
			unitDTORemoved = UnitDTOAssembler.toDTO( unitRemoved );
		}
		
		return unitDTORemoved;
	}

	@Override
	@Transactional
	public UnitDTO save( UnitDTO unitDTO ) {
		
		if ( unitDTO == null 
				|| unitDTO.getDescription() == null 
				|| unitDTO.getDescription().isEmpty() ) {
			throw new IllegalArgumentException();
		}
		
		Unit unit = new Unit( unitDTO.getDescription() );
		
		Unit unitAdded = unitRepository.add( unit );
		
		UnitDTO unitDTOAdded = null;
		
		if ( unitAdded != null ) {
			unitDTOAdded = UnitDTOAssembler.toDTO( unitAdded );
		}
		
		return unitDTOAdded;
	}

	@Override
	@Transactional( readOnly = true )
	public UnitDTO find( Long id ) {
		
		if ( id == null ) {
			throw new IllegalArgumentException();
		}
		
		Unit unit = unitRepository.find( id );
		
		UnitDTO unitDTO = null;
		
		if ( unit != null ) {
			unitDTO = UnitDTOAssembler.toDTO( unit );
		}
		
		return unitDTO;
	}

	@Override
	@Transactional( readOnly = true )
	public List<UnitDTO> findAll() {
		
		List<Unit> units = unitRepository.findAll();
		
		List<UnitDTO> unitsDTO = null;
		
		if ( units != null ) {
			unitsDTO = UnitDTOAssembler.toDTOList( units );
		}
		
		return unitsDTO;
	}

}

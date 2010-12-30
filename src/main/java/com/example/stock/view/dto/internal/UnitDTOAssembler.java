package com.example.stock.view.dto.internal;

import java.util.ArrayList;
import java.util.List;

import com.example.stock.domain.entity.Unit;
import com.example.stock.view.dto.UnitDTO;
import com.example.util.Util;

/**
 * @author fabiano.barreto
 *
 */
public class UnitDTOAssembler {

	public static UnitDTO toDTO( Unit unit ) { 
		
		if ( unit == null ) {
			throw new IllegalArgumentException( "Impossible convert types for a null parameter: unit." );
		}
		
		UnitDTO UnitDTO = ( UnitDTO ) Util.copyProperties( UnitDTO.class, unit );
		
		return UnitDTO;
	}
	
	public static List<UnitDTO> toDTOList( List<Unit> units ) {
		
		if ( units == null ) {
			throw new IllegalArgumentException();
		}
		
		List<UnitDTO> unitsDTO = new ArrayList<UnitDTO>();
		
		for ( Unit unit : units ) { 
			unitsDTO.add( toDTO( unit ) );
		}
		
		return unitsDTO;
	}
	
}

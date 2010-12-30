package com.example.stock.view.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.example.stock.service.UnitService;
import com.example.stock.view.dto.UnitDTO;

/**
 * @author fabiano.barreto
 *
 */
@RequestScoped
@ManagedBean( name = "unitMB" )
public class UnitManagedBean {

	@ManagedProperty( value = "#{unitService}" )
	private UnitService unitService;
	
	@ManagedProperty( value = "#{unitDTO}" )
	private UnitDTO unit;

	private List< UnitDTO > units;
	
	public void save() {
		
		unit = getUnitService().save( getUnit() );
	}

	/**
	 * @return the unit
	 */
	public UnitDTO getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(UnitDTO unit) {
		this.unit = unit;
	}
	
	/**
	 * @return the unitService
	 */
	public UnitService getUnitService() {
		return unitService;
	}

	/**
	 * @param unitService the unitService to set
	 */
	public void setunitService( UnitService unitService ) {
		this.unitService = unitService;
	}
	
	public List< UnitDTO > getUnits() {
		
		if ( units == null ) {
			units = unitService.findAll();
		}
		
		return units;
	}
	
}

package com.example.stock.view.dto;

import org.springframework.stereotype.Component;

import com.example.stock.view.BaseDTO;

/**
 * @author fabiano.barreto
 *
 */
@Component( "unitDTO" )
public class UnitDTO extends BaseDTO {

	private Long id;
	
	private String description;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}

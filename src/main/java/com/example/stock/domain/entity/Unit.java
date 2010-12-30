package com.example.stock.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.stock.domain.BaseEntity;

/**
 * @author fabiano.barreto
 *
 */
@Entity
@Table( name = "UNIT" )
public class Unit extends BaseEntity {

	private static final long serialVersionUID = -1326188584633678547L;

	@Id
	@Column( name = "ID", length = 5 )
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	@Column( name = "DESCRIPTION", length = 100, unique = true )
	private String description;
	
	public Unit() {
		// For Hibernate
	}

	public Unit( String description ) {
		this.description = description;
	}
	
	/**
	 * @return the id
	 */
	@Override
	public Long getId() {
		return id;
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

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}

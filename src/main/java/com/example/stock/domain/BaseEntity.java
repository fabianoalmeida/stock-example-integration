package com.example.stock.domain;

import java.io.Serializable;

import javax.persistence.Transient;

/**
 * @author fabiano.barreto
 *
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5410980547966092247L;

	private static Long HASH_CODE;

	@Transient
	private boolean selected;

	@Transient
	private Long hashCode;

	static {
		HASH_CODE = -1L;
	}

	{
		// Todos os objetos recebem um hashcode único.
		hashCode = HASH_CODE--;
	}

	/**
	 * Método a ser implementado por todas as classes que extenderem esta.
	 */
	public abstract Long getId();

	/**
	 * Verifica se eh/esta selected.
	 * 
	 * @return true, caso for selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Atribui o parametro selected a propriedade selected.
	 * 
	 * @param selected
	 *            o novo valor do atributo selected
	 */
	public void setSelected( boolean selected ) {
		this.selected = selected;
	}

	/**
	 * Obtem a propriedade index.
	 * 
	 * @return a propriedade index
	 */
	public Long getIndex() {

		if ( getId() != null ) {
			return getId();
		}

		return hashCode;
	}

	@Override
	public int hashCode() {

		if ( getId() != null ) {
			return getId().hashCode();
		}

		return hashCode.hashCode();
	}

	@Override
	public boolean equals( Object entityCandidate ) {

		if ( entityCandidate == null ) {
			return false;
		}

		if ( entityCandidate instanceof BaseEntity ) {

			BaseEntity canditado = ( BaseEntity ) entityCandidate;

			// Testamos pelo id real
			if ( getId() != null 
					&& canditado.getId() != null ) {

				return getId().equals( canditado.getId() );

				// Testamos pelo id falso
			} else if ( hashCode != null 
					&& canditado.hashCode != null ) {
				
				return hashCode.equals( canditado.hashCode );
			}
		}

		return false;
	}

	@Override
	public String toString() {

		String idStr = null;
		
		if ( getId() == null ) {
			idStr = hashCode.toString();
		} else {
			idStr = getId().toString();
		}
		
		StringBuffer strBuffer = new StringBuffer( idStr );
		strBuffer.append( "@" ).append( getClass().getSimpleName() );

		return strBuffer.toString();
	}
	
}

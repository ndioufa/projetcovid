package com.fa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cassuspect")
@PrimaryKeyJoinColumn(name = "id")
public class CasSuspect extends Cas{
	@Column
	private String symtome;

	public CasSuspect() {
		super();
	}

	public CasSuspect(String symtome) {
		super();
		this.symtome = symtome;
	}

	public String getSymtome() {
		return symtome;
	}

	public void setSymtome(String symtome) {
		this.symtome = symtome;
	}
	

}

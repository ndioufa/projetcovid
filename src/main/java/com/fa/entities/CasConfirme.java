package com.fa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "casconfirme")
@PrimaryKeyJoinColumn(name = "id")
public class CasConfirme extends Cas {
	@Column
	private Date dateConfirmation;

	public CasConfirme() {
		super();
	}

	public CasConfirme(Date dateConfirmation) {
		super();
		this.dateConfirmation = dateConfirmation;
	}

	public Date getDateConfirmation() {
		return dateConfirmation;
	}

	public void setDateConfirmation(Date dateConfirmation) {
		this.dateConfirmation = dateConfirmation;
	}
	

}

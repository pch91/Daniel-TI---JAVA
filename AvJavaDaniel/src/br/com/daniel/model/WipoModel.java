package br.com.daniel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;


@DynamicInsert
@DynamicUpdate
@javax.persistence.Entity(name="wipo")
public class WipoModel implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	String n_pud;
	
	String n_ped_int;
	
	Date dt_pub;
	
	String requerentes;
	
	String titulo;

	public String getN_pud() {
		return n_pud;
	}

	public void setN_pud(String n_pud) {
		this.n_pud = n_pud;
	}

	public String getN_ped_int() {
		return n_ped_int;
	}

	public void setN_ped_int(String n_ped_int) {
		this.n_ped_int = n_ped_int;
	}

	public Date getDt_pub() {
		return dt_pub;
	}

	public void setDt_pub(Date dt_pub) {
		this.dt_pub = dt_pub;
	}

	public String getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(String requerentes) {
		this.requerentes = requerentes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}

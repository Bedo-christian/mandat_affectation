package com.fujitsu.affectation.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the affectation database table.
 * 
 */
@Entity
@NamedQuery(name="Affectation.findAll", query="SELECT a FROM Affectation a")
public class Affectation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_affectation")
	private int idAffectation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_debut")
	private Date dateDebut;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_fin")
	private Date dateFin;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="id_employe")
	private Employe employe;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="code_projet")
	private Projet projet;

	public Affectation() {
	}

	public int getIdAffectation() {
		return this.idAffectation;
	}

	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
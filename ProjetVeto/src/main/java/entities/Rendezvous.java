package entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;



/**
 * The persistent class for the rendezvous database table.
 * 
 */
@Entity
@NamedQuery(name="Rendezvous.findAll", query="SELECT r FROM Rendezvous r")
public class Rendezvous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rendezvous")
	private int idRendezvous;

	@Temporal(TemporalType.DATE)
	@Column(name="date_rendezvous")
	private Date dateRendezvous;

	@Column(name="heure_rendezvous")
	private Date heureRendezvous;

	@Column(name="raison_visite")
	private String raisonVisite;

	private String statut;

	//bi-directional many-to-one association to Animal
	@ManyToOne
	@JoinColumn(name="id_animal")
	private Animal animal;

	public Rendezvous() {
	}

	public int getIdRendezvous() {
		return this.idRendezvous;
	}

	public void setIdRendezvous(int idRendezvous) {
		this.idRendezvous = idRendezvous;
	}

	public Date getDateRendezvous() {
		return this.dateRendezvous;
	}

	public void setDateRendezvous(Date parsedDate) {
		this.dateRendezvous = parsedDate;
	}

	public Date getHeureRendezvous() {
		return this.heureRendezvous;
	}

	public void setHeureRendezvous(Date parsedTime) {
		this.heureRendezvous = parsedTime;
	}

	public String getRaisonVisite() {
		return this.raisonVisite;
	}

	public void setRaisonVisite(String raisonVisite) {
		this.raisonVisite = raisonVisite;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Animal getAnimal() {
		return this.animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
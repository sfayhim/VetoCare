package entities;

import java.io.Serializable;
import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a"),
	@NamedQuery(name="Animal.getAllAnimalsByOwner", query="SELECT a FROM Animal a where a.proprietaire.nom= ?1")
})

public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_animal")
	private int idAnimal;

	private int age;

	private String espece;

	private String nom;

	private String race;

	private String sexe;

	//bi-directional many-to-one association to Proprietaire
	@ManyToOne
	@JoinColumn(name="id_proprietaire")
	private Proprietaire proprietaire;

	//bi-directional many-to-one association to Rendezvous
	@OneToMany(mappedBy="animal", fetch=FetchType.EAGER)
	private List<Rendezvous> rendezvouses;

	public Animal() {
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEspece() {
		return this.espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Proprietaire getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Rendezvous> getRendezvouses() {
		return this.rendezvouses;
	}

	public void setRendezvouses(List<Rendezvous> rendezvouses) {
		this.rendezvouses = rendezvouses;
	}

	public Rendezvous addRendezvous(Rendezvous rendezvous) {
		getRendezvouses().add(rendezvous);
		rendezvous.setAnimal(this);

		return rendezvous;
	}

	public Rendezvous removeRendezvous(Rendezvous rendezvous) {
		getRendezvouses().remove(rendezvous);
		rendezvous.setAnimal(null);

		return rendezvous;
	}

}
package entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

import java.util.List;


/**
 * The persistent class for the proprietaire database table.
 * 
 */
@Entity
@NamedQuery(name="Proprietaire.findAll", query="SELECT p FROM Proprietaire p")
public class Proprietaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proprietaire")
	private int idProprietaire;

	private String email;

	private String nom;

	@Column(name="numero_contact")
	private String numeroContact;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="proprietaire", fetch=FetchType.EAGER)
	private List<Animal> animals;

	public Proprietaire() {
	}

	public int getIdProprietaire() {
		return this.idProprietaire;
	}

	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroContact() {
		return this.numeroContact;
	}

	public void setNumeroContact(String numeroContact) {
		this.numeroContact = numeroContact;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setProprietaire(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setProprietaire(null);

		return animal;
	}

}
package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the vet database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Vet.findAll", query="SELECT v FROM Vet v"),
@NamedQuery(name="Vet.getVetoByNameandPassword", query="SELECT v FROM Vet v where v.nom= ?1 and v.pwd = ?2")
})
public class Vet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vet")
	private int idVet;

	private String nom;

	private String pwd;

	public Vet() {
	}

	public int getIdVet() {
		return this.idVet;
	}

	public void setIdVet(int idVet) {
		this.idVet = idVet;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Animal;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class AnimalService
 */
@Stateless
@LocalBean
public class AnimalService {
	
	@PersistenceContext(unitName="ProjetVeto")
	private EntityManager em;
	
	/**
     * Default constructor. 
     */
    public AnimalService() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Animal> getAllAnimals()
    {
    List<Animal> animals = new ArrayList<Animal>();
    TypedQuery<Animal> query =
    em.createNamedQuery("Animal.findAll",Animal.class);
    animals = query.getResultList();
    return animals;
    }
    
    public List<Animal> getAllAnimalsByOwner(String Owner){
	    List<Animal> animals = new ArrayList<Animal>();
	    TypedQuery<Animal> query = em.createNamedQuery("Animal.getAllAnimalsByOwner",Animal.class);
	    query.setParameter(1, Owner);
	    animals = query.getResultList();
	    return animals;
    }
 // Delete
    public List<Animal> deleteAnimalById(int animalId){
    	List<Animal> animals = new ArrayList<Animal>();
    	Animal pet = em.find(Animal.class, animalId);
    	if(pet!=null) { em.remove(pet);}
    	TypedQuery<Animal> query =
    	em.createNamedQuery("Subject.findAll",Animal.class);
    	animals= query.getResultList();
    	return animals;
    }
 // Insert
    public void addAnimal(Animal animal) {
 		em.persist(animal);
    }
 // Update
    public Animal updateAnimal(Animal pet) {
    	Animal a =em.find(Animal.class, pet.getIdAnimal());
    	if (pet.getEspece()!="") a.setEspece(pet.getEspece());
    	if (pet.getRace()!="") a.setRace(pet.getRace());
    	if(pet.getAge()>0) a.setAge(pet.getAge());
    	if (pet.getSexe()!="") a.setSexe(pet.getSexe());
    	if (pet.getProprietaire()!=null) a.setProprietaire(pet.getProprietaire());
    	if (pet.getRendezvouses()!=null) a.setRendezvouses(pet.getRendezvouses());
    	return a;
    }
 // Select
    public Animal getAnimalById(int idAnimal) {
        return em.find(Animal.class, idAnimal);
    }
 		

}

package mvcModel;

import java.util.ArrayList;
import java.util.List;


import entities.Proprietaire;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class ProprietaireService
 */
@Stateless
@LocalBean
public class ProprietaireService {
	@PersistenceContext(unitName="ProjetVeto")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProprietaireService() {
        // TODO Auto-generated constructor stub
    }
    public List<Proprietaire> getAllProp()
    {
    List<Proprietaire> ownerList = new ArrayList<Proprietaire>();
    TypedQuery<Proprietaire> query =
    em.createNamedQuery("Proprietaire.findAll",Proprietaire.class);
    ownerList = query.getResultList();
    return ownerList;
    }
 // Delete
    public List<Proprietaire> deleteOwnerById(int PropId){
    	List<Proprietaire> owners = new ArrayList<Proprietaire>();
    	Proprietaire owner = em.find(Proprietaire.class, PropId);
    	if(owner!=null) { em.remove(owner);}
    	TypedQuery<Proprietaire> query =
    	em.createNamedQuery("Subject.findAll",Proprietaire.class);
    	owners= query.getResultList();
    	return owners;
    }
 // Insert
    public void addOwner(Proprietaire owner) {
 		em.persist(owner);
    }
 // Update
    public Proprietaire updateOwner(Proprietaire proprietaire) {
        Proprietaire prop = em.find(Proprietaire.class, proprietaire.getIdProprietaire());
        if (proprietaire.getNom() != null && !proprietaire.getNom().isEmpty()) {
            prop.setNom(proprietaire.getNom());
        }
        if (proprietaire.getEmail() != null && !proprietaire.getEmail().isEmpty()) {
            prop.setEmail(proprietaire.getEmail());
        }
        if (proprietaire.getNumeroContact() != null && !proprietaire.getNumeroContact().isEmpty()) {
            prop.setNumeroContact(proprietaire.getNumeroContact());
        }
        return prop;
    }
 // Select
    public Proprietaire getOwnerbyId(int propId) {
        return em.find(Proprietaire.class, propId);
    }
 		

}

package mvcModel;

import java.util.List;

import entities.Vet;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class VetService
 */
@Stateless
@LocalBean
public class VetService {
	@PersistenceContext(unitName="ProjetVeto")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public VetService() {
        // TODO Auto-generated constructor stub
    }
    public Vet getVetoByNameandPassword(String nom,String pass) {
    	TypedQuery<Vet> query=em.createNamedQuery("Vet.getVetoByNameandPassword", Vet.class);
    	query.setParameter(1,nom);
    	query.setParameter(2, pass);
    	List<Vet> res=query.getResultList();
    	if(!res.isEmpty()) {
    		return res.get(0);
    	}
    	else {
    		return null;
    	}
    }

}

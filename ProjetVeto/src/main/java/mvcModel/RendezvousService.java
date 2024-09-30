package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Rendezvous;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
@LocalBean
public class RendezvousService {
    @PersistenceContext(unitName="ProjetVeto")
    private EntityManager em;

    public RendezvousService() {
    }

    public List<Rendezvous> getAllRdv() {
        List<Rendezvous> ListRdv = new ArrayList<Rendezvous>();
        TypedQuery<Rendezvous> query = em.createNamedQuery("Rendezvous.findAll",Rendezvous.class);
        ListRdv = query.getResultList();
        return ListRdv;
    }

    public void addRdv(Rendezvous rdv) {
        em.persist(rdv);
    }

    public Rendezvous updateRendezvous(Rendezvous rendezvous) {
        Rendezvous existingRdv = em.find(Rendezvous.class, rendezvous.getIdRendezvous());
        if (existingRdv == null) {
            return null;
        }
        existingRdv.setDateRendezvous(rendezvous.getDateRendezvous());
        existingRdv.setHeureRendezvous(rendezvous.getHeureRendezvous());
        existingRdv.setRaisonVisite(rendezvous.getRaisonVisite());
        existingRdv.setStatut(rendezvous.getStatut());
        if (rendezvous.getAnimal() != null) {
            existingRdv.setAnimal(rendezvous.getAnimal());
        }

        return existingRdv;
    }

    public List<Rendezvous> deleteRendezvousById(int rendezvousId) {
        List<Rendezvous> rendezvousList = new ArrayList<>();
        Rendezvous rendezvous = em.find(Rendezvous.class, rendezvousId);
        if (rendezvous != null) {
            em.remove(rendezvous);
        }
        TypedQuery<Rendezvous> query = em.createNamedQuery("Rendezvous.findAll", Rendezvous.class);
        rendezvousList = query.getResultList();
        return rendezvousList;
    }
}

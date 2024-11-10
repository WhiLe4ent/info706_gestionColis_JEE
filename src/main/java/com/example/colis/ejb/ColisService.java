package src.main.java.com.example.colis.ejb;

import src.main.java.com.example.colis.entities.Colis;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * EJB Colis 
 */
@Stateless
public class ColisService {

    @PersistenceContext(unitName = "colisPU")
    private EntityManager em;

    public Colis creerColis(Colis colis) {
        em.persist(colis);
        return colis;
    }

    public Colis mettreAJourColis(Colis colis) {
        return em.merge(colis);
    }

    public Colis getColis(Long id) {
        return em.find(Colis.class, id);
    }  


    public List<Colis> listerTousLesColis() {
        String jpql = "SELECT c FROM Colis c";         
        TypedQuery<Colis> query = em.createQuery(jpql, Colis.class);
        List<Colis> listeColis = query.getResultList(); 
        return listeColis ;
    }
}

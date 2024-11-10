package src.main.java.com.example.colis.ejb;

import src.main.java.com.example.colis.entities.Colis;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ColisService {

    @PersistenceContext(unitName = "colisPU")
    private EntityManager em;

    // Méthode pour créer un colis
    public Colis creerColis(Colis colis) {
        em.persist(colis);
        return colis;
    }

    // Méthode pour mettre à jour un colis
    public Colis mettreAJourColis(Colis colis) {
        return em.merge(colis);
    }

    // Méthode pour récupérer un colis par son ID
    public Colis obtenirColis(Long id) {
        return em.find(Colis.class, id);
    }

    // Méthode pour supprimer un colis
    public void supprimerColis(Long id) {
        Colis colis = obtenirColis(id);
        if (colis != null) {
            em.remove(colis);
        }
    }

   
    // Méthode pour récupérer toutes les positions d'un colis
    public Colis obtenirPositionColis(Long colisId) {
        Colis colis = obtenirColis(colisId);
        return colis != null ? colis : null;
    }

    // Nouvelle méthode pour lister tous les colis
    public List<Colis> listerTousLesColis() {
        String jpql = "SELECT c FROM Colis c"; // Requête JPQL pour récupérer tous les colis
        TypedQuery<Colis> query = em.createQuery(jpql, Colis.class);
        return query.getResultList(); 
    }
}

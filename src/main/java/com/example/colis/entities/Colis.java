package src.main.java.com.example.colis.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Entite Colis 
 */
@Getter
@Setter
@Entity
public class Colis implements Serializable {

    @Id
    private Long id;

    private String origine;
    private String destination;
    private Double poids;
    private Double valeur;

    private double latitude;
    private double longitude;
    private String emplacement;
    private String etat;

    private LocalDateTime datePosition;



}
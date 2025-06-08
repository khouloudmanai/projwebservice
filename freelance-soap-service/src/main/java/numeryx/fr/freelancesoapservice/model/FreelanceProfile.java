package numeryx.fr.freelancesoapservice.model;


import jakarta.persistence.*;

@Entity
public class FreelanceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String specialites;
    private String lienLinkedIn;
    private String lienPortfolio;

    // Getters et Setters
}
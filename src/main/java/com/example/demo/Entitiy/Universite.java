package com.example.demo.Entitiy;
import com.example.demo.Entitiy.Foyer;
import jakarta.persistence.*;
        import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@ToString
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresse;
    @OneToOne
    @JoinColumn(name="foyer_id")
    private Foyer foyer ;
    @ManyToOne
    @JoinColumn(name = "universite_id_universite")
    private Universite universite;

    public String getNomUniversite() { return nomUniversite; }

    public String getAdresse() { return adresse ; }

    // ✅ CES SETTERS DOIVENT EXISTER :
    public void setNomUniversite(String nomUniversite) { this.nomUniversite = nomUniversite; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Universite getUniversite() {
        return this.universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public Foyer getFoyer() {
        return this.foyer;
    }
}


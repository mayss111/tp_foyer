package com.example.demo.Entitiy;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@ToString

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long idchambre;
    long nombrehambre;
    @Enumerated(EnumType.STRING)
    Typechambre typechambre;
    @ManyToOne
    Bloc bloc;
    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    public void setIdChambre(Long id) {
    }
    public void setBloc(Bloc bloc) {
    }

    public String getNumeroChambre(long nombrechambre) {
        return null;
    }
    public Typechambre getTypeC() { return typechambre; } // pas getTypechambre()

    public Bloc getBloc() {
        return this.bloc;
    }


    public Long getNumeroChambre() {
        return this.nombrehambre;
    }
}


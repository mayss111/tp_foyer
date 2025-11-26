package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
    private Long nombrehambre;
    @Enumerated(EnumType.STRING)
    Typechambre typeC;
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
    public Typechambre getTypeC() { return typeC; } // pas getTypechambre()

    public Bloc getBloc() {
        return this.bloc;
    }


    public Long getNumeroChambre() {
        return this.nombrehambre;
    }
}


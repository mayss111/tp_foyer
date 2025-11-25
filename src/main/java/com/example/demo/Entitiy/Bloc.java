package com.example.demo.Entitiy;

import jakarta.persistence.*;
import lombok.*;

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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private String capaciteBloc;
    @ManyToOne
    Foyer foyer;
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    private Set<Chambre> chambres = new HashSet<>();

    public void setId(Long id) {
    }
    // ✅ AJOUTEZ CETTE MÉTHODE :
    public String getNomBloc() {
        return this.nomBloc;
    }
    public void setBloc (Bloc bloc) {}
}

package com.example.demo.Entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "bloc")
    List<Chambre> chambres;

}

package com.example.demo.Entitiy;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import javax.print.DocFlavor;
import java.util.List;

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
    @OneToMany
    List<Reservation> reservations;

}

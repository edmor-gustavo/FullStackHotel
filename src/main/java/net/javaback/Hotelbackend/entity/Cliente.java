package net.javaback.Hotelbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "identidade")
    private String identidade;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "numero_quarto")
    private String numeroQuarto;

}

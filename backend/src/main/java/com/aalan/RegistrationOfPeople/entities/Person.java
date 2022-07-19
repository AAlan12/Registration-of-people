package com.aalan.RegistrationOfPeople.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "Data de Nascimento")
    private Date dataNascimento;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "CEP")
    private Integer cep;

    @Column(name = "Número")
    private Integer numero;

    @Column(name = "Cidade")
    private String cidade;

}

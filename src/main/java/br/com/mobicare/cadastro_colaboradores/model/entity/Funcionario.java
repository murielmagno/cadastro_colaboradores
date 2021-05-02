package br.com.mobicare.cadastro_colaboradores.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    LocalDate data_admissao;

    @Column
    LocalDate data_demissao;

    @OneToOne
    @JoinColumn(name = "id_pessoa",nullable = false,unique = true)
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "id_setor",nullable = false)
    private Setor setor;

}

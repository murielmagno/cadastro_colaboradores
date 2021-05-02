package br.com.mobicare.cadastro_colaboradores.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {

    private Integer id;
    private Integer id_pessoa;
    private Integer id_setor;
    private LocalDate data_admissao;
    private LocalDate data_demissao;

}

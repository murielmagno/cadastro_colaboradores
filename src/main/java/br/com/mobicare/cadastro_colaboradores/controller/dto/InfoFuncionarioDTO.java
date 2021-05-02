package br.com.mobicare.cadastro_colaboradores.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoFuncionarioDTO {
    private Integer codigo;
    private String nomeFuncionario;
    private String email;
    private String setor;

}

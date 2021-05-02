package br.com.mobicare.cadastro_colaboradores.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoSetorDTO {
    private String descricaoSetor;
}

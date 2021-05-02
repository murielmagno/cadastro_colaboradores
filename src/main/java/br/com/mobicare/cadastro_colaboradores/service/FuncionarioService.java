package br.com.mobicare.cadastro_colaboradores.service;

import br.com.mobicare.cadastro_colaboradores.controller.dto.FuncionariosDTO;
import br.com.mobicare.cadastro_colaboradores.model.entity.Funcionario;
import br.com.mobicare.cadastro_colaboradores.model.entity.Setor;

import java.util.Optional;

public interface FuncionarioService {

    Funcionario salvar(FuncionariosDTO dto);

    Optional<Funcionario> consultarFuncionario(Integer id);

    Optional<Funcionario> consultarFuncionarioSetor(Integer id);
}

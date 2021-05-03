package br.com.murielmagno.cadastro_colaboradores.service;

import br.com.murielmagno.cadastro_colaboradores.dto.FuncionariosDTO;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    Funcionario salvar(FuncionariosDTO dto);

    Optional<Funcionario> consultarFuncionario(Integer id);

}

package br.com.mobicare.cadastro_colaboradores.service;

import br.com.mobicare.cadastro_colaboradores.controller.dto.FuncionariosDTO;
import br.com.mobicare.cadastro_colaboradores.controller.repository.Funcionarios;
import br.com.mobicare.cadastro_colaboradores.controller.repository.Pessoas;
import br.com.mobicare.cadastro_colaboradores.controller.repository.Setores;
import br.com.mobicare.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.mobicare.cadastro_colaboradores.model.entity.Funcionario;
import br.com.mobicare.cadastro_colaboradores.model.entity.Pessoa;
import br.com.mobicare.cadastro_colaboradores.model.entity.Setor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{

    private Funcionarios funcionariosRepository;
    private Pessoas pessoasRepository;
    private Setores setoresRepository;


    @Override
    @Transactional
    public Funcionario salvar(FuncionariosDTO dto) {
        Integer idPessoa = dto.getId_pessoa();
        Pessoa pes = pessoasRepository.findById(idPessoa)
                .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Código de pessoa invalido"));
        Funcionario funcionario = new Funcionario();
        funcionario.setPessoa(pes);
        Integer idSetor = dto.getId_setor();
        Setor se = setoresRepository.findById(idSetor)
                .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Código de pessoa invalido"));
        funcionario.setSetor(se);
        funcionario.setData_admissao(LocalDate.now());
        funcionario.getId();
        return funcionario;
    }

    @Override
    public Optional<Funcionario> consultarFuncionario(Integer id) {
        return funcionariosRepository.findById(id);
    }

    @Override
    public Optional<Funcionario> consultarFuncionarioSetor(Integer id) {
        return funcionariosRepository.findByIdFetchSetor(id);
    }
}

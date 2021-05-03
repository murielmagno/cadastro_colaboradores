package br.com.murielmagno.cadastro_colaboradores.service;

import br.com.murielmagno.cadastro_colaboradores.dto.FuncionariosDTO;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Funcionarios;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Pessoas;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Setores;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Funcionario;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Pessoa;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Setor;
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
                    .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Código do setor invalido"));
        funcionario.setSetor(se);
        funcionario.setData_admissao(LocalDate.now());
        return funcionario;
    }

    @Override
    public Optional<Funcionario> consultarFuncionario(Integer id) {
        return funcionariosRepository.findById(id);
    }

}

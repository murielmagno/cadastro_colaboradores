package br.com.murielmagno.cadastro_colaboradores.controller;

import br.com.murielmagno.cadastro_colaboradores.dto.FuncionariosDTO;
import br.com.murielmagno.cadastro_colaboradores.dto.InfoFuncionarioDTO;
import br.com.murielmagno.cadastro_colaboradores.model.repository.Funcionarios;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Funcionario;
import br.com.murielmagno.cadastro_colaboradores.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/cadastroFuncionario")
public class FuncionarioController {

    private FuncionarioService service;
    private Funcionarios funcionarios;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@RequestBody FuncionariosDTO dto) {
        Funcionario funcionario = service.salvar(dto);
        return funcionarios.save(funcionario);
    }

    @GetMapping("{id}")
    public InfoFuncionarioDTO infoFuncionarioById(@PathVariable Integer id) {
        return service.consultarFuncionario(id).map(fun -> transformar(fun))
                .orElseThrow(() ->
                        new RegraCadastroException(
                                HttpStatus.NOT_FOUND, "Funcionario não encontrado."));
    }


    private InfoFuncionarioDTO transformar(Funcionario funcionario) {
        return InfoFuncionarioDTO.builder().codigo(funcionario.getId())
                .nomeFuncionario(funcionario.getPessoa().getNome())
                .email(funcionario.getPessoa().getEmail())
                .setor(funcionario.getSetor().getDesc())
                .build();
    }

}

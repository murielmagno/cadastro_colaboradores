package br.com.mobicare.cadastro_colaboradores.controller;

import br.com.mobicare.cadastro_colaboradores.controller.dto.FuncionariosDTO;
import br.com.mobicare.cadastro_colaboradores.controller.dto.InfoFuncionarioDTO;
import br.com.mobicare.cadastro_colaboradores.controller.repository.Funcionarios;
import br.com.mobicare.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.mobicare.cadastro_colaboradores.model.entity.Funcionario;
import br.com.mobicare.cadastro_colaboradores.service.FuncionarioService;
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

    @GetMapping("/setor/{id}")
    public String findByIdFetchSetor(@PathVariable Integer id){
        return service.consultarFuncionarioSetor(id).map(funcionario -> funcionario
                .getPessoa().getNome())
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

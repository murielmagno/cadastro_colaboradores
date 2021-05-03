package br.com.murielmagno.cadastro_colaboradores.controller;

import br.com.murielmagno.cadastro_colaboradores.model.repository.Setores;
import br.com.murielmagno.cadastro_colaboradores.exception.RegraCadastroException;
import br.com.murielmagno.cadastro_colaboradores.model.entity.Setor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/setor")
public class SetorController {
    private Setores setores;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setor save(@RequestBody Setor setor) {
        return setores.save(setor);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Setor setor) {
        setores.findById(id)
                .map(v -> {
                    setor.setId(v.getId());
                    setores.save(setor);
                    return setor;
                }).orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Setor não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        setores.findById(id)
                .map(s -> {
                    setores.delete(s);
                    return Void.TYPE;
                }).orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Setor não encontrado"));
    }

    @GetMapping("{id}")
    public Setor getById(@PathVariable Integer id) {
        return setores.findById(id)
                .orElseThrow(() -> new RegraCadastroException(HttpStatus.BAD_REQUEST, "Setor não encontrada"));

    }

    @GetMapping("/listaSetores")
    public List<Setor> find(Setor setor) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(setor, matcher);
        return setores.findAll(example);
    }

}

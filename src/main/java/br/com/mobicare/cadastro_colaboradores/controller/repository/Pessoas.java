package br.com.mobicare.cadastro_colaboradores.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mobicare.cadastro_colaboradores.model.entity.Pessoa;

import java.util.List;

public interface Pessoas extends JpaRepository<Pessoa,Integer> {

    List<Pessoa> findByNomeLike(String nome);

    Pessoa findOneByCpf(String cpf);

    Pessoa findOneByEmail(String email);

}

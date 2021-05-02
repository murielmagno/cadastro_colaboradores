package br.com.mobicare.cadastro_colaboradores.controller.repository;

import br.com.mobicare.cadastro_colaboradores.model.entity.Funcionario;
import br.com.mobicare.cadastro_colaboradores.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Funcionarios  extends JpaRepository<Funcionario,Integer> {
    List<Funcionario> findByPessoa(Pessoa pessoa);

    @Query(" select a from Funcionario as a left join Setor b on a.setor=b.id ")
    Optional<Funcionario> findByIdFetchSetor(@Param("id") Integer id);
}

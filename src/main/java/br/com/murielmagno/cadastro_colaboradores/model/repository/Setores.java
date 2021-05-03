package br.com.murielmagno.cadastro_colaboradores.model.repository;

import br.com.murielmagno.cadastro_colaboradores.model.entity.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Setores extends JpaRepository<Setor,Integer> {
}

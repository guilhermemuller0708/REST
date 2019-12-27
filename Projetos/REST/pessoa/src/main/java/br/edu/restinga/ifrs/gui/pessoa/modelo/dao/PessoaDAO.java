package br.edu.restinga.ifrs.gui.pessoa.modelo.dao;

import br.edu.restinga.ifrs.gui.pessoa.modelo.entidade.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaDAO extends CrudRepository<Pessoa, Integer> {

}

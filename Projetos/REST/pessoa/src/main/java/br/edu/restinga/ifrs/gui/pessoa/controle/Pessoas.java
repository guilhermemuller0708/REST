package br.edu.restinga.ifrs.gui.pessoa.controle;

import br.edu.restinga.ifrs.gui.pessoa.modelo.dao.PessoaDAO;
import br.edu.restinga.ifrs.gui.pessoa.modelo.entidade.Pessoa;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Pessoas {

    @Autowired
    PessoaDAO pessoaDAO;

    @PostMapping("/pessoas/")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        pessoaDAO.save(pessoa);
        return pessoa;
    }

    @GetMapping("/pessoas/")
    public Iterable<Pessoa> listarPessoas() {
        return pessoaDAO.findAll();
    }

    @PutMapping("/pessoas/{id}")
    public void atualizarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        pessoaDAO.save(pessoa);

    }

    @DeleteMapping("/pessoas/{id}")
    public void deletarPessoa(@PathVariable int id) {
        pessoaDAO.deleteById(id);
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa recuperarPessoa(@PathVariable int id) {
        Optional<Pessoa> optionalPessoa = pessoaDAO.findById(id);
        if (optionalPessoa.isPresent()) {
            return optionalPessoa.get();
        } else {
            return null;
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga.dev1.superLoja.modelo.servico;

import br.edu.ifrs.restinga.dev1.superLoja.excecoes.NaoEncontrado;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.dao.ProdutoDAO;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.entidade.Produto;
import br.edu.ifrs.restinga.dev1.superLoja.modelo.rn.ProdutoRN;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jezer
 */
@Component
public class ProdutoServico {

    @Autowired
    ProdutoDAO produtoDAO;
    @Autowired
    ProdutoRN produtoRN;

    public Produto cadastrar(Produto produto) {
        produtoRN.validar(produto);
        Produto produtoBanco = produtoDAO.save(produto);
        return produtoBanco;
    }

    public Iterable<Produto> listar() {
        return produtoDAO.findAll();
    }

    public void atualizar(Produto produto) {
        produtoRN.validar(produto);
        produtoDAO.save(produto);
    }

    public Produto recuperar(int id) throws Throwable {
        Optional<Produto> optionalProduto = produtoDAO.findById(id);
        if(!optionalProduto.isPresent())
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        return optionalProduto.get();
        //return optionalProduto.orElseThrow(()->{throw new NaoEncontrado("");});
    }
    
     public void excluir(int id) {
        if(!produtoDAO.existsById(id))
            throw new NaoEncontrado("id "+id+" não foi encontrada");
        produtoDAO.deleteById(id);
    }
    
}

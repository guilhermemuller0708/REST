package br.edu.ifrs.restinga.dev1.superLoja.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontrado extends RuntimeException {
    public NaoEncontrado(String mensagem) {
        super(mensagem);
    }

}

package br.edu.ifrs.restinga.dev1.superLoja.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuebraRegraNegocio extends RuntimeException {
    public QuebraRegraNegocio(String erro) {
        super(erro);
    }
}

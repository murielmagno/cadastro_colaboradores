package br.com.mobicare.cadastro_colaboradores.exception;

import org.springframework.http.HttpStatus;

public class RegraCadastroException extends RuntimeException {
    public RegraCadastroException(HttpStatus badRequest, String msg) {
        super(msg);
    }
}

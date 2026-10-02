package dev.felipeazsantos.planeja.common.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Registro não encontrado.");
    }
}

package com.webminds.project.core.excepciones;

public class ModoPagoNoExisteException extends Exception{
    public  ModoPagoNoExisteException(Integer id) {
        super("El modo de pago con el ID " + id + " no existe en base de datos, porfavor verifiquelo o creelo.");
    }
}

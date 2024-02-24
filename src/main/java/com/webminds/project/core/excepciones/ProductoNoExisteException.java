package com.webminds.project.core.excepciones;

public class ProductoNoExisteException extends Exception{
    public ProductoNoExisteException(Integer id) {
        super("El producto con el ID " + id + " no existe en base de datos, porfavor verifiquelo o creelo.");
    }
}

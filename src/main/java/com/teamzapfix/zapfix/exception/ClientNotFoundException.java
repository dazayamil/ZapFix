package com.teamzapfix.zapfix.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id){
        super("Client not found with ID: " + id);
    }
}

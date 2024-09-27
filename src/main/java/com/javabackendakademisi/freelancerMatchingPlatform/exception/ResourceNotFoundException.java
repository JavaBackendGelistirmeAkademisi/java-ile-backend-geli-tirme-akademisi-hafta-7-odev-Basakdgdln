package com.javabackendakademisi.freelancerMatchingPlatform.exception;

// Kaynak bulunamadığında fırlatılacak özel hata
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
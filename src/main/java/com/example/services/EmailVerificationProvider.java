package com.example.services;

public interface EmailVerificationProvider {
    /**
     * Verifies if the given email is valid and reachable.
     * 
     * @param email The email address to verify
     * @return true if valid, false otherwise
     */
    boolean verifyEmail(String email);
} 

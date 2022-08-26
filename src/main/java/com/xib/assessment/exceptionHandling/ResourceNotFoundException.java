package com.xib.assessment.exceptionHandling;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException (String message) {
        super(message);
    }
}

package org.example.canvasbe.exception;

public class DrawingStateNotFoundException extends RuntimeException {
    
    public DrawingStateNotFoundException(String message) {
        super(message);
    }
    
    public DrawingStateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
} 
package me.fit.exception;

public class ProizvodException extends Exception {

    private String message;

    public ProizvodException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

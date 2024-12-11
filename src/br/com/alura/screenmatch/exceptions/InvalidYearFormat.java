package br.com.alura.screenmatch.exceptions;

public class InvalidYearFormat extends RuntimeException {
    private String message;
    public InvalidYearFormat(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

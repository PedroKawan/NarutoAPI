package me.pedrokaua.narutoapi.exceptions;

public class CharacterNotFoundException extends RuntimeException{

    private String message;
    private Throwable cause;

    public CharacterNotFoundException(){
        this.message = "Character not found.";
    }

    public CharacterNotFoundException(String message){
        this.message = message;
    }

    public CharacterNotFoundException(Throwable cause){
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}

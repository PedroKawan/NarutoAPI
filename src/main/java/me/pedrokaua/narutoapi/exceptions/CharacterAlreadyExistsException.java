package me.pedrokaua.narutoapi.exceptions;

public class CharacterAlreadyExistsException extends RuntimeException{

    private String message;
    private Throwable cause;

    public CharacterAlreadyExistsException(){
        this.message = "Character already exists in database.";
    }

    public CharacterAlreadyExistsException(String message){
        this.message = message;
    }

    public CharacterAlreadyExistsException(Throwable cause){
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

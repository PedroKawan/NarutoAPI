package me.pedrokaua.narutoapi.exceptions;

public class UpdateCharacterException extends RuntimeException{

    private String message;
    private Throwable cause;

    public UpdateCharacterException(){
        this.message = "Update character error!";
    }

    public UpdateCharacterException(String message){
        this.message = message;
    }

    public UpdateCharacterException(Throwable cause){
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

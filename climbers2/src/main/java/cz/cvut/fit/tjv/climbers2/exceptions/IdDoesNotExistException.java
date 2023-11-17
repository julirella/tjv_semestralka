package cz.cvut.fit.tjv.climbers2.exceptions;

public class IdDoesNotExistException extends RuntimeException{
    public IdDoesNotExistException(String message) {
        super(message);
    }
}

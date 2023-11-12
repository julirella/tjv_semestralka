package cz.cvut.fit.tjv.climbers2.business;

public class IdDoesNotExistException extends RuntimeException{
    public IdDoesNotExistException(String message) {
        super(message);
    }
}

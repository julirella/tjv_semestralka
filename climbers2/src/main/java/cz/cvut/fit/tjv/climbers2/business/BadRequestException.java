package cz.cvut.fit.tjv.climbers2.business;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}

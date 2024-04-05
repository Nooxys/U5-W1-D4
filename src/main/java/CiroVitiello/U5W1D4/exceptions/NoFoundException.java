package CiroVitiello.U5W1D4.exceptions;

public class NoFoundException extends RuntimeException {
    public NoFoundException(long id) {
        super("the Item with: " + id + " was not found!");
    }
}
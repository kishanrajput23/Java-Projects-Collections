package replit;

public class GameAlreadyExistsException extends Exception{
  public GameAlreadyExistsException(String errorMessage) {
    super(errorMessage);
  }
}
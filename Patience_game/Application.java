public class Application {
  public static void main(String[] args) {
    PatienceGame game = new PatienceGame();
    GameConsoleUI consoleUI = new GameConsoleUI(game);
    consoleUI.start();
  }
}
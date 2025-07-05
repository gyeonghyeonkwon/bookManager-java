import app.App;
import bookmanager.BookManager;
import console.ConsoleHelper;
import database.Jdbc;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Jdbc jdbc = new Jdbc();
    ConsoleHelper console = new ConsoleHelper(new Scanner(System.in));
    App app = new App(console);
    jdbc.driverLoad();
    app.run();
  }
}

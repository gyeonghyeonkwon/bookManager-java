import app.App;
import bookmanager.BookManager;
import console.ConsoleHelper;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    ConsoleHelper console = new ConsoleHelper();
    App app = new App(console);
    app.run();
  }
}

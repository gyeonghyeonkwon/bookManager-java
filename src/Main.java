import app.App;
import bookmanager.BookManager;
import console.ConsoleHelper;
import database.Jdbc;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args){
    new Jdbc();
    ConsoleHelper console = new ConsoleHelper(new Scanner(System.in));
    App app = new App(console);
    app.run();
  }
}

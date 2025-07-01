import app.App;
import bookmanager.BookManager;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    BookManager bookManager = new BookManager(sc);
    App app = new App(sc);
    app.run();
  }
}

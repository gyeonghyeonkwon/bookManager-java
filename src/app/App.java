package app;

import book.Book;
import bookmanager.BookManager;
import java.util.Scanner;

public class App {

  private final Scanner sc;
  private BookManager bookManager;

  public App(Scanner sc) {
    bookManager = new BookManager(sc);
    this.sc = sc;
  }
  public void run () {
    while (true) {
      System.out.println("==== 도서 관리 프로그램 ====");
      System.out.println("1. 도서 등록");
      System.out.println("2. 도서 목록 조회");
      System.out.println("3. 도서 검색");
      System.out.println("4. 도서 정보 수정");
      System.out.println("5. 도서 삭제");
      System.out.println("6. 종료");
      int menuNumber = bookManager.readInt("메뉴 선택: ");

      switch (menuNumber) {

        case 1 -> bookManager.addBook();
        case 2 -> bookManager.listOfBooks();
        case 3 -> bookManager.searchKeyword();
        case 6 ->  {
          System.out.println("프로그램을 종료합니다. 감사합니다.");
          return;
        }
        default -> System.out.println("입력하신 번호가 존재하지않습니다. 다시입력해주세요.");
      }
    }
  }
}

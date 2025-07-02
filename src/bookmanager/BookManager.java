package bookmanager;

import book.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager{

  private  final Scanner sc;
  private final List<Book> books;

  public BookManager(Scanner sc) {
    this.books = new ArrayList<>();
    this.sc = sc;
  }
  public void addBook() {
    System.out.println("==== 도서 등록 ====");
    int isbn;
    while (true) {
      System.out.print("번호 입력: ");
      isbn = sc.nextInt();
      sc.nextLine(); // 버퍼에 남은 개행문자 제거
      if (isDuplicate(isbn)) {
        System.out.println("번호를 다시 입력해주세요.");
        continue;
      }
      break;
    }

    System.out.print("제목 입력: ");
    String title= sc.nextLine();

    System.out.print("작가 이름: ");
    String author= sc.nextLine();

    System.out.print("출판사: ");
    String publisher= sc.nextLine();

    System.out.print("출판일: ");
    String date= sc.nextLine();

    Book book = new Book(isbn , title , author , publisher , date);
    books.add(book);
  }
  public void listOfBooks() {
    System.out.println("==== 도서 목록 ====");
    System.out.println("총 " + books.size() + "권의 도서가 등록되어있습니다.");
    if (books.isEmpty()) {
      System.out.println("등록된 도서가 없습니다.");
    }
    printBookList(); //책 리스트 출력
    sc.nextLine(); //버퍼 지우기
    System.out.println("계속하려면 엔터 키를 누르세요...");
    sc.nextLine();
  }
  public void searchKeyword() {
    System.out.println("==== 도서 검색 ====");
    System.out.println("검색할 항목 선택");
    System.out.println("1. 제목");
    System.out.println("2. 저자");
    System.out.println("3. ISBN");
    System.out.print("선택: ");
    choiceKeyword();

  }

  private void choiceKeyword () {
    int choice = sc.nextInt();
    sc.nextLine();
    if (choice == 1) {
      System.out.print("검색어 입력: ");
      String searchKeyword =  sc.nextLine();
      int count = countSearchedBooks(searchKeyword); //책 제목 검색결과 책의 갯수
      System.out.println(">> 검색 결과: " + "(" + count + "권" + ")");
      printSearchBookList(searchKeyword);
    }
  }

  private int countSearchedBooks(String searchKeyword) {
    int count = 0;
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getTitle().contains(searchKeyword)) {
        count++;
      }
    }
    return count;
  }

  private void printSearchBookList(String searchKeyword) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getTitle().contains(searchKeyword)) {
        printBooks(i);
      }
    }
    System.out.println("계속하려면 엔터 키를 누르세요...");
    sc.nextLine();
  }

  private void printBookList() {
    for (int i = books.size() - 1; i >= 0; i--) { //최신순
      printBooks(i);
    }
  }
  private void printBooks(int i) {
    System.out.println("-".repeat(32));
    System.out.println("ISBN: " + books.get(i).getIsbn());
    System.out.println("제목: " + books.get(i).getTitle());
    System.out.println("저자: " + books.get(i).getAuthor());
    System.out.println("출판사: " + books.get(i).getPublisher());
    System.out.println("출판년도: " + books.get(i).getDate());
    System.out.println("-".repeat(32));
  }

  //리스트에 고유번호가 중복되면 true
  private boolean isDuplicate(int isbn) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getIsbn() == isbn) {
        return true;
      }
    }
    return false;
  }
}

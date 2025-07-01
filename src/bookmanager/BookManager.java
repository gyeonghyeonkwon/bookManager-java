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
    System.out.print("번호 입력: ");
    int isbn = sc.nextInt();
    sc.nextLine(); // 버퍼에 남은 개행문자 제거

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
}

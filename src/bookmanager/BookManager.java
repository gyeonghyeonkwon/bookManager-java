package bookmanager;

import book.Book;
import console.ConsoleHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookManager {

  private final ConsoleHelper console;
  private final List<Book> books;

  public BookManager(ConsoleHelper console) {
    this.books = new ArrayList<>();
    this.console = console;
  }

  public void addBook() {
    System.out.println("==== 도서 등록 ====");
    int isbn;
    while (true) {
      isbn = console.getReadInt("번호 입력: ");
      if (isDuplicate(isbn)) {
        System.out.println("번호가 중복되었습니다. 번호를 다시 입력해주세요.");
      } else {
        break;
      }
    }

    String title = console.getReadLine("제목 입력: ");
    String author = console.getReadLine("작가 이름: ");
    String publisher = console.getReadLine("출판사: ");
    String date = console.getReadLine("출판일: ");

    Book book = new Book(isbn, title, author, publisher, date);
    books.add(book);
    System.out.println("도서가 성공적으로 등록되었습니다.");
  }

  public void listOfBooks() {
    System.out.println("==== 도서 목록 ====");
    System.out.println("총 " + books.size() + "권의 도서가 등록되어있습니다.");
    if (books.isEmpty()) {
      System.out.println("등록된 도서가 없습니다.");
    }
    printBookList(books); //책 전체리스트 출력
    System.out.println("계속하려면 엔터 키를 누르세요...");
    console.getNextLine(); //버퍼 지우기
  }

  public void searchBook() {
    System.out.println("==== 도서 검색 ====");
    System.out.println("검색할 항목 선택");
    System.out.println("1. 제목");
    System.out.println("2. 저자");
    System.out.println("3. ISBN");

    int choice = console.getReadInt("선택: ");

    String keyword = console.getReadLine("검색어 입력: ");

    List<Book> bookSearchList = new ArrayList<>();//검색된 책목록


    switch (choice) {
      case 1 -> bookSearchList = searchBooksTitle(keyword); //검색결과 책리스트
      case 2 -> bookSearchList = searchBooksAuthor(keyword);
      case 3 -> bookSearchList = searchBooksIsbn(keyword);
      default -> System.out.println("번호를 다시 입력해주세요.");
    }
    System.out.println(">> 검색 결과: " + "(" + bookSearchList.size() + "권" + ")");
    if (bookSearchList.isEmpty()) {
      System.out.println("도서를 찾을수 없습니다.");
    }
    printBookList(bookSearchList);
    System.out.println("계속하려면 엔터 키를 누르세요...");
    console.getNextLine();
  }

  public void updateBook() {
    long isbn = console.getReadInt("수정할 도서의 ISBN 입력: ");
    Book book = findByBook(isbn);

    if (book == null) {
      System.out.println("도서를 찾을수 없습니다.");
      return;
    }

    System.out.println(" >> 현재정보");
    printBooks(book);
    String updateTitle = console.getReadOptionalLine("수정할 제목 입력 (수정하지 않으려면 엔터): ",
        book.getTitle());
    book.setTitle(updateTitle);
    String updateAuthor = console.getReadOptionalLine("수정할 작가 입력 (수정하지 않으려면 엔터): ",
        book.getAuthor());
    book.setAuthor(updateAuthor);
    String updatePublisher = console.getReadOptionalLine("수정할 출판사 입력 (수정하지 않으려면 엔터): ",
        book.getPublisher());
    book.setPublisher(updatePublisher);
    String updateDate = console.getReadOptionalLine("수정할 출판일 입력 (수정하지 않으려면 엔터): ",
        book.getDate());
    book.setDate(updateDate);
    System.out.println(">> 도서 정보가 수정되었습니다.");
  }

  public void removeBooks() {
    int isbn = console.getReadInt("삭제할 도서의 ISBN 입력: ");
    Book book = findByBook(isbn);

    if (book == null) {
      System.out.println("도서를 찾을수 없습니다.");
      return;
    }
    printBooks(book);
    String confirm = console.getReadLine("정말 삭제하시겠습니까? (Y/N): ");
    if (confirm.equals("Y") || confirm.equals("y")) {
      books.remove(book);
      System.out.println("도서가 삭제되었습니다.");
    }
  }

  private Book findByBook(long isbn) {
    //isbn이 없으면 null 반환
    return books.stream()
        .filter(book -> book.getIsbn() == isbn)
        .findFirst() //optional로 반환
        .orElse(null);
  }

  private List<Book> searchBooksTitle(String keyword) {
    return books.stream()
        .filter(book -> book.getTitle().equals(keyword))
        .collect(Collectors.toList());
  }

  private List<Book> searchBooksAuthor(String keyword) {
    return books.stream()
        .filter(book -> book.getAuthor().equals(keyword))
        .collect(Collectors.toList());
  }

  private List<Book> searchBooksIsbn(String keyword) {
    return books.stream()
        .filter(book -> String.valueOf(book.getIsbn()).equals(keyword)) //조건문
        .collect(Collectors.toList()); //새로운 리스트에 담아서 반환
  }

  private void printBookList(List<Book> bookList) {
    List<Book> copyList = new ArrayList<>(bookList);
    Collections.reverse(copyList); //역순
    copyList.stream().forEach(this::printBooks);
  }

  private void printBooks(Book book) {
    System.out.println("-".repeat(32));
    System.out.println("ISBN: " + book.getIsbn());
    System.out.println("제목: " + book.getTitle());
    System.out.println("저자: " + book.getAuthor());
    System.out.println("출판사: " + book.getPublisher());
    System.out.println("출판년도: " + book.getDate());
    System.out.println("-".repeat(32));
  }

  //리스트에 고유번호가 중복되면 true
  private boolean isDuplicate(int isbn) {
    return books.stream()
        .anyMatch(book -> book.getIsbn() == isbn);
  }
}

package book;

import java.time.LocalDate;

public class Book {

  long isbn; //고유번호
  String bookName; //책이름
  String author; //저자
  String publisher; //출판사
  String date; //출판일

  public Book(long isbn, String bookName, String author, String publisher, String date) {
    this.isbn = isbn;
    this.bookName = bookName;
    this.author = author;
    this.publisher = publisher;
    this.date = date;
  }

  public String getBookName() {
    return bookName;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public long getIsbn() {
    return isbn;
  }

  public String getDate() {
    return date;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public void setDate(String date) {
    this.date = date;
  }
}

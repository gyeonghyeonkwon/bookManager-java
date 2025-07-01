package book;

import java.time.LocalDate;

public class Book {

  int isbn; //고유번호
  String title; //책이름
  String author; //저자
  String publisher; //출판사
  String date; //출판일

  public Book(int isbn, String title, String author, String publisher, String date) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.date = date;
  }

  public Book (){}

  public int getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getDate() {
    return date;
  }

  public void setTitle(String title) {
    this.title = title;
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

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.print.DocFlavor.STRING;

public class Jdbc  {

  String url = "jdbc:mysql://localhost:3306/book";
  String user = "root";
  String password = "1234";

  public Jdbc() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("JDBC 드라이버 로드 성공!");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
    }
  }
  // 연결 반환
  public Connection getConnection() throws SQLException {
    Connection con = DriverManager.getConnection(url, user, password);
    System.out.println("데이터베이스 접속 성공!");
    return con;
  }
}


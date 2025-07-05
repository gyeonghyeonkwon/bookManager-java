package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

  String url = "jdbc:mysql://localhost:3306/book";
  String user = "root";
  String password = "1234";

  public void driverLoad() {
    // JDBC 드라이버 로드
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC 드라이버 로드하는데 문제 발생 : " + e.getMessage());
      e.printStackTrace();
    }
    // 접속
    Connection con = null;

    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("연결 완료");
    }
    catch (SQLException e) {
      System.out.println("연결 오류 : " + e.getMessage());
    }finally {
      // 접속 종료
      try {
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {}
    }
    if (con != null) {
      System.out.println("데이터베이스 접속 성공!");
    }
  }
}


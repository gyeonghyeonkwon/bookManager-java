package console;

import java.util.Scanner;

public class ConsoleHelper {

  private final Scanner sc = new Scanner(System.in);

  //scanner 메서드
  public String getReadLine(String input) {
    System.out.print(input);
    return sc.nextLine();
  }

  public int getReadInt(String input) {
    System.out.print(input);
    while (!sc.hasNextInt()) { //입력값이 정수가 아닐때 실행
      System.out.print("숫자를 입력해주세요: ");
      sc.next();
    }
    return sc.nextInt(); //정수일때 반환
  }
  public String getNextLine() {
    return sc.nextLine();
  }
}

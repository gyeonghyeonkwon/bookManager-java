package console;

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ConsoleHelper {

  private final Scanner sc;

  public ConsoleHelper(Scanner sc) {
    this.sc = sc;
  }

  //새로 명령받는 메서드
  public String getReadLine(String prompt) {
    String input;
    while (true) {
      System.out.print(prompt);
      input = sc.nextLine().trim();
      if (!input.isEmpty()) {
        break;
      }
      System.out.println("공백은 입력할 수 없습니다. 다시 입력해주세요.");
    }
    return input;
  }

  // 수정명령받는 메서드
  public String getReadOptionalLine(String prompt , String currentValue) {
    System.out.print(prompt);
    String newValue = sc.nextLine().trim();
    if (newValue.isEmpty()) { //새로입력 해야할 입력값이 공백이면
      return currentValue; // 기존 값 반환
    }
    return newValue; //공백이 아니면 새 입력값 반환
  }

  public int getReadInt(String prompt) {
    String input;
    int value;
    while (true) {
      System.out.print(prompt);
      input = sc.nextLine().trim(); // 한 줄 전체 읽고 앞뒤 공백 제거

      if (input.isEmpty()) {
        System.out.println("공백은 입력할 수 없습니다. 숫자를 입력해주세요.");
        continue;
      }
      try {
        value = Integer.parseInt(input);
        break; // 정상적으로 파싱되면 반복 종료
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력해주세요."); //예외발생하면 실행
      }
    }
    return value;
  }

  public String getNextLine() {
    return sc.nextLine();
  }
  }

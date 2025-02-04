package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 값 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String word = Console.readLine();

        // 기본 구분자 설정
        ArrayList<String> operatorList = new ArrayList<String>();
        operatorList.add(",");
        operatorList.add(":");

        // 커스텀 구분자 인식
        Pattern p = Pattern.compile("//\\D\\\\n");
        Matcher m = p.matcher(word);
        if (m.find()) {
            operatorList.add(String.valueOf(word.charAt(m.start()+2)));
        }
        word = word.substring(m.end());

        // 구분자 정리
        String[] operatorArray = new String[operatorList.size()];
        for (int i = 0; i < operatorList.size(); i++)
            operatorArray[i] = operatorList.get(i);
        String operator = String.join("|", operatorArray);

        // 숫자 연산
        int sum = 0;
        String[] result = word.split(operator);
        for (String s : result) {
            sum += Integer.parseInt(s);
        }

        System.out.println(String.format("결과 : %d", sum));
    }
}

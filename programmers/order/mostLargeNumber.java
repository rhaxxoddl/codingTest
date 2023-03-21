package order;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class mostLargeNumber {
    static public String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        list.sort((String s1, String s2) -> compareString(s1, s2));
        StringBuilder answer = new StringBuilder();
        for (String s : list) {
            answer.append(s);
        }
        return answer.toString();
    }

    static public int compareString(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            int diff = s2.charAt(i) - s1.charAt(i);
            if (diff != 0)
                return diff;
        }
        if (s1.length() > s2.length()) {
            return compareString(s1.substring(s2.length()), s2);
        } else if (s1.length() < s2.length()){
            return compareString(s1, s2.substring(s1.length()));
        } else
            return 0;
    }

    static private void grade(String result, String expect_result) {
        if (Objects.equals(result, expect_result))
            System.out.println("O");
        else {
            System.out.println("X");
            System.out.println("expected result: " + expect_result);
            System.out.println();
            System.out.println("your result: " + result);
        }
    }

    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        String expect1 = "6210";
        String expect2 = "9534330";
        grade(solution(numbers1), expect1);
        grade(solution(numbers2), expect2);
    }
}

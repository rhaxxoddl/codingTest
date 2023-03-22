package stack_queue;

import java.util.Objects;

public class collect_bracket {
    static public boolean solution(String s) {
        int bracket = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                bracket++;
            else if (bracket == 0 && s.charAt(i) == ')')
                return false;
            else if (s.charAt(i) == ')')
                bracket--;
        }
        return bracket == 0;
    }
    static private void grade(boolean result, boolean expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals)
            System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        boolean expect1 = true;
        boolean expect2 = true;
        boolean expect3 = false;
        boolean expect4 = false;
        grade(solution(s1), expect1);
        grade(solution(s2), expect2);
        grade(solution(s3), expect3);
        grade(solution(s4), expect4);
    }
}

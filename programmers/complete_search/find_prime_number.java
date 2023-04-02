package complete_search;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class find_prime_number {
    static public int solution(String numbers) {
        Set<Integer> prime_set = new HashSet<>();

        make_combination(prime_set, new StringBuilder(), new StringBuilder(numbers));
        return prime_set.size();
    }

    static private void make_combination(Set<Integer> prime_set, StringBuilder number, StringBuilder src) {
        for (int i = 0; i < src.length(); i++) {
            StringBuilder str = new StringBuilder(number).append(src.charAt(i));
            Integer num = Integer.parseInt(str.toString());
            if (is_prime_number(num))
                prime_set.add(num);
            make_combination(prime_set, str, (new StringBuilder(src)).deleteCharAt(i));
        }
    }
    static private boolean is_prime_number(Integer number) {
        if (number <= 1)
            return false;
        else if (number == 2 || number == 3)
            return true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static private void grade(int result, int expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals)
            System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        String operations1 = "17";
        String operations2 = "011";
        String operations3 = "211";
        String operations4 = "1231";

        int expect1 = 3;
        int expect2 = 2;
        int expect3 = 3;
        int expect4 = 18;

        grade(solution(operations1), expect1);
        grade(solution(operations2), expect2);
        grade(solution(operations3), expect3);
        grade(solution(operations4), expect4);
    }
}

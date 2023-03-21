package order;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class H_Index {
    static public int solution(int[] citations) {
        List<Integer> sortList = IntStream.of(citations).boxed().sorted(Collections.reverseOrder(Integer::compareTo)).collect(Collectors.toList());
        int answer = 0;
        for (int i = 0; i < sortList.size(); i++) {
            if (sortList.get(i) >= i + 1)
                answer = i + 1;
            else
                break;
        }
        return answer;
    }

    static private void grade(Object result, Object expect_result) {
        if (Objects.equals(result, expect_result))
            System.out.println("O");
        else {
            System.out.println("X");
            System.out.println("expected result: " + expect_result.toString());
            System.out.println();
            System.out.println("your result: " + result.toString());
        }
    }

    public static void main(String[] args) {
        int[] numbers1 = {3, 0, 6, 1, 5};
        int[] numbers2 = {4, 20, 4, 5};

        int expect1 = 3;
        int expect2 = 4;
        grade(solution(numbers1), expect1);
        grade(solution(numbers2), expect2);
    }
}

package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class noSameNumber {
    static public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int recent = -1;
        for (int num: arr) {
            if (num != recent) {
                recent = num;
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
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
        int[] numbers1 = {1, 1, 3, 3, 0, 1, 1};
        int[] numbers2 = {4, 4, 4, 3, 3};

        int[] expect1 = {1, 3, 0, 1};
        int[] expect2 = {4, 3};
        grade(solution(numbers1), expect1);
        grade(solution(numbers2), expect2);
    }
}

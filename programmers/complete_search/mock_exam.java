package complete_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mock_exam {
    static final private int[] first_pattern = {1, 2, 3, 4, 5};
    static final private int[] second_pattern = {2, 1, 2, 3, 2, 4, 2, 5};
    static final private int[] third_pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static public int[] solution(int[] answers) {
        int[] score = new int[3];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            score[0] += check_first_person(i, answers[i]);
            score[1] += check_second_person(i, answers[i]);
            score[2] += check_third_person(i, answers[i]);
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, score[i]);
        }
        for (int i = 0; i < 3; i++) {
            if (score[i] == max)
                result.add(i + 1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static private int check_first_person(int idx, int answer) {
        int i = idx >= first_pattern.length ? idx % first_pattern.length : idx;
        return first_pattern[i] == answer ? 1 : 0;
    }

    static private int check_second_person(int idx, int answer) {
        int i = idx >= second_pattern.length ? idx % second_pattern.length : idx;
        return second_pattern[i] == answer ? 1 : 0;
    }

    static private int check_third_person(int idx, int answer) {
        int i = idx >= third_pattern.length ? idx % third_pattern.length : idx;
        return third_pattern[i] == answer ? 1 : 0;
    }

    static private void grade(int[] result, int[] expect_result) {
        Boolean equals = Arrays.equals(result, expect_result);
        if (equals)
            System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        int[] operations1 = {1, 2, 3, 4, 5};
        int[] operations2 = {1, 3, 2, 4, 2};
        int[] operations3 = {0};
        int[] operations4 = {1};
        int[] operations5 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        int[] expect1 = {1};
        int[] expect2 = {1, 2, 3};
        int[] expect3 = {1, 2, 3};
        int[] expect4 = {1};
        int[] expect5 = {1};

        grade(solution(operations1), expect1);
        grade(solution(operations2), expect2);
        grade(solution(operations3), expect3);
        grade(solution(operations4), expect4);
        grade(solution(operations5), expect5);
    }
}

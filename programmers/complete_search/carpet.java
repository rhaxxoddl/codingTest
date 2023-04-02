package complete_search;

import java.util.Arrays;

public class carpet {
    static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int y_h = 1; y_h <= yellow; y_h++) {
            if (yellow % y_h != 0)
                continue;
            int y_l = yellow / y_h;
            if (2 * (y_l + y_h + 2) == brown) {
                answer[0] = y_l + 2;
                answer[1] = y_h + 2;
                break;
            }
        }
        return answer;
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
        int brown1 = 10;
        int brown2 = 8;
        int brown3 = 24;

        int yellow1 = 2;
        int yellow2 = 1;
        int yellow3 = 24;

        int[] expect1 = {4, 3};
        int[] expect2 = {3, 3};
        int[] expect3 = {8, 6};

        grade(solution(brown1, yellow1), expect1);
        grade(solution(brown2, yellow2), expect2);
        grade(solution(brown3, yellow3), expect3);
    }
}

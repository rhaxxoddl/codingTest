package complete_search;

import java.util.Objects;

public class min_rectangle {
    static public int solution(int[][] sizes) {
        int min = 0;
        int max = 0;
        for (int[] size: sizes) {
            int card_min = Math.min(size[0], size[1]);
            int card_max = Math.max(size[0], size[1]);
            min = Math.max(min, card_min);
            max = Math.max(max, card_max);
        }
        return min * max;
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
        int[][] operations1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] operations2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] operations3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        int expect1 = 4000;
        int expect2 = 120;
        int expect3 = 133;

        grade(solution(operations1), expect1);
        grade(solution(operations2), expect2);
        grade(solution(operations3), expect3);
    }
}

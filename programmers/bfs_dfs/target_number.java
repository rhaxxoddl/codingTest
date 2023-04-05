package bfs_dfs;

import java.util.Objects;

public class target_number {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int index, int current_number, int target) {
        if (index == numbers.length)
            return current_number == target ? 1 : 0;
        return dfs(numbers, index + 1, current_number - numbers[index], target) + dfs(numbers, index + 1, current_number + numbers[index], target);
    }

    static private void grade(long result, long expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals) System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        target_number targetNumber = new target_number();
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};

        int target1 = 3;
        int target2 = 4;

        int expect1 = 5;
        int expect2 = 2;

        grade(targetNumber.solution(numbers1, target1), expect1);
        grade(targetNumber.solution(numbers2, target2), expect2);
    }
}

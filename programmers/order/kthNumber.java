package order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class kthNumber {

    static public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = findKthNumber(list, commands[i]);
        }
        return answer;
    }

    static private int findKthNumber(List<Integer> list, int [] commands) {
        List<Integer> temp = new ArrayList<>(list.subList(commands[0] - 1, commands[1]));
        temp.sort(Integer::compareTo);
        return temp.get(commands[2] - 1);
    }

    static private void grade(int[] result, int[] expect_result) {
        if (result == expect_result)
            System.out.println("O");
        else {
            System.out.println("X");
            System.out.println("expected result: ");
            for (int j : expect_result) {
                System.out.print(j + ", ");
            }
            System.out.println();
            System.out.println("your result: ");
            for (int j : result) {
                System.out.print(j + ", ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};

        int[][] commands1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] expect1 = {5, 6, 3};
        grade(solution(array1, commands1), expect1);
    }
}

package stack_queue;

import java.util.Arrays;

public class stock_price {
    static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = count;
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
        int[] prices1 = {1, 2, 3, 2, 3};

        int[] expect1 = {4, 3, 1, 1, 0};
        grade(solution(prices1), expect1);
    }
}

package heap;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class more_spicy {
    static public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovillePQ = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int answer = 0;
        while (true) {
            if (scovillePQ.peek() != null && scovillePQ.peek() >= K)
                return answer;
            if (scovillePQ.size() == 1)
                return -1;
            Integer first = scovillePQ.poll();
            Integer second = scovillePQ.poll();
            scovillePQ.add(first + second * 2);
            answer++;
        }
    }

    static private void grade(Object result, Object expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals)
            System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        int[] scoville1 = {1, 2, 3, 2, 3};
        int[] scoville2 = {1, 2, 3, 9, 10, 12};

        int k1 = 7;
        int k2 = 7;

        int expect1 = 3;
        int expect2 = 2;
        grade(solution(scoville1, k1), expect1);
        grade(solution(scoville2, k2), expect2);
    }
}

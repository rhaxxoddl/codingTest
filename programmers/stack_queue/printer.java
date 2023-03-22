package stack_queue;

import java.util.*;

public class printer {
    static public int solution(int[] priorities, int location) {
        Queue<List<Integer>> q = generateQueue(priorities);
        int answer = 0;
        while (q.size() > 0) {
            if (isMostPrior(q.peek().get(1), q)) {
                List<Integer> e = q.poll();
                answer++;
                if (e.get(0) == location)
                    return answer;
            } else {
                List<Integer> e = q.poll();
                q.add(e);
            }
        }
        return answer;
    }

    static private boolean isMostPrior(int prior, Queue<List<Integer>> q) {
        for (List<Integer> list : q) {
            if (list.get(1) > prior)
                return false;
        }
        return true;
    }
    static private Queue<List<Integer>> generateQueue(int[] priorities) {
        Queue<List<Integer>> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            List<Integer> e = new ArrayList<>();
            e.add(i);
            e.add(priorities[i]);
            q.add(e);
        }
        return q;
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
        int[] priorities1 = {2, 1, 3, 2};
        int[] priorities2 = {1, 1, 9, 1, 1, 1};

        int location1 = 2;
        int location2 = 0;

        int expect1 = 1;
        int expect2 = 5;
        grade(solution(priorities1, location1), expect1);
        grade(solution(priorities2, location2), expect2);
    }
}

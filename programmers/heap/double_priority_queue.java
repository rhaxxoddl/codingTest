package heap;

import java.util.*;
import java.util.stream.Collectors;

public class double_priority_queue {
    static public int[] solution(String[] operations) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (String operation :operations) {
            if (operation.equals("D 1") && q.size() > 0){
                List<Integer> list = q.stream().sorted().collect(Collectors.toList());
                if (list.size() > 0)
                    list.remove(list.size() - 1);
                q = new PriorityQueue<>(list);
            } else if (operation.equals("D -1") && q.size() > 0) {
                q.poll();
            } else if (operation.contains("I")) {
                Integer addNumber = Integer.valueOf(operation.substring(2));
                q.add(addNumber);
            }
        }
        return getAnswer(q);
    }

    static private int[] getAnswer(PriorityQueue<Integer> queue) {
        if (queue.size() == 0)
            return new int[]{0, 0};
        else {
            int[] answer = new int[2];
            answer[1] = queue.peek();
            List<Integer> list = queue.stream().sorted().collect(Collectors.toList());
            answer[0] = list.get(list.size() - 1);
            return answer;
        }
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
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        String[] operations3 = {"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"};
        String[] operations4 = {"I 1", "I 5", "I 3", "D 1"};
        String[] operations5 = {"I 1", "I 3", "I 5", "I 7", "I 9", "D -1", "D -1", "D 1", "I 2", "D 1", "D 1"};
        String[] operations6 = {"D 1"};
        String[] operations7 = {"I 1", "I 2", "I 1"};
        String[] operations8 = {"I 1", "I 3", "I 2"};

        int[] expect1 = {0, 0};
        int[] expect2 = {333, -45};
        int[] expect3 = {8, 3};
        int[] expect4 = {3, 1};
        int[] expect5 = {2, 2};
        int[] expect6 = {0, 0};
        int[] expect7 = {2, 1};
        int[] expect8 = {3, 1};

        grade(solution(operations1), expect1);
        grade(solution(operations2), expect2);
        grade(solution(operations3), expect3);
        grade(solution(operations4), expect4);
        grade(solution(operations5), expect5);
        grade(solution(operations6), expect6);
        grade(solution(operations7), expect7);
        grade(solution(operations8), expect8);
    }
}

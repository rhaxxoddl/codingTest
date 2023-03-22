package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class featureDevelop {
    static public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int nextPublishing = 0;
        int finishProgresses = 0;
        for (int i = 0; nextPublishing < progresses.length; i++) {
            if (isFinished(progresses[nextPublishing], speeds[nextPublishing], i)) {
                while (nextPublishing < progresses.length && isFinished(progresses[nextPublishing], speeds[nextPublishing], i))
                    nextPublishing++;
                answer.add(nextPublishing - finishProgresses);
                finishProgresses = nextPublishing;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static public boolean isFinished(int progresse, int speed, int time) {
        return progresse + (speed * time) >= 100;
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
        int[] progresses1 = {93, 30, 55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};

        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] expect1 = {2, 1};
        int[] expect2 = {1, 3, 2};
        grade(solution(progresses1, speeds1), expect1);
        grade(solution(progresses2, speeds2), expect2);
    }
}

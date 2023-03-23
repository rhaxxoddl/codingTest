package heap;

import java.util.*;
import java.util.stream.Collectors;

public class disk_controller {
    class Job implements Comparable<Job> {
        int request_time;
        int requiredTime;
        Integer start_time;

        @Override
        public int compareTo(Job o) {
            if (this.start_time != null && o.start_time == null)
                return -1;
            else if (this.start_time == null && o.start_time != null) {
                return 1;
            }
            if (this.requiredTime == o.requiredTime)
                return this.request_time - o.request_time;
            return this.requiredTime - o.requiredTime;
        }

        public Job(int request_time, int requiredTime) {
            this.request_time = request_time;
            this.requiredTime = requiredTime;
            this.start_time = null;
        }
        public boolean isFinished(int currentTime) {
            return requiredTime  == currentTime - start_time;
        }
    }
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>(
                Arrays.stream(jobs)
                        .map(job ->
                                new Job(job[0], job[1])
                        )
                        .collect(Collectors.toList()));
        jobList.sort((e1, e2) -> e1.request_time - e2.request_time);
        PriorityQueue<Job> diskPQ = new PriorityQueue<>();
        int time = 0;
        int endJobCount = 0;
        int answer = 0;
        while (endJobCount < jobs.length) {
            while (jobList.size() > 0 && jobList.get(0).request_time <= time) {
                Job job = jobList.get(0);
                jobList.remove(0);
                diskPQ.offer(job);
            }
            if (diskPQ.peek() != null) {
                diskPQ.peek().start_time = time;
                while (!diskPQ.peek().isFinished(time)) {
                    time++;
                }
                    answer += time - diskPQ.poll().request_time;
                    endJobCount++;
            } else
                time++;
        }
        return answer / jobs.length;
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
        disk_controller diskController = new disk_controller();
        int[][] jobs1 = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs2 = {{0, 1}, {3, 10}};
        int[][] jobs3 = {{5, 1}, {3, 10}};
        int[][] jobs4 = {{0, 1}, {1, 9}, {5, 1}, {3, 10}};
        int[][] jobs5 = {{0, 1}, {1, 9}, {5, 3}, {5, 1}, {3, 10}};
        int[][] jobs6 = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
        int[][] jobs7 = {{0, 10}, {2, 10}, {9, 19}, {15, 17}};

        int expect1 = 9;
        int expect2 = 5;
        int expect3 = 10 / 2 + (13 - 5 + 1) / 2;
        int expect4 = 8;
        int expect5 = 9;
        int expect6 = 14;
        int expect7 = 24;
        grade(diskController.solution(jobs1), expect1);
        grade(diskController.solution(jobs2), expect2);
        grade(diskController.solution(jobs3), expect3);
        grade(diskController.solution(jobs4), expect4);
        grade(diskController.solution(jobs5), expect5);
        grade(diskController.solution(jobs6), expect6);
        grade(diskController.solution(jobs7), expect7);
    }
}

package bfs_dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class network {
    static class Computer{
        int number;
        List<Computer> connectComputer;
        public Computer(int number) {
            this.number = number;
            connectComputer = new ArrayList<>();
        }

        public void connect(int[] connectInfo, List<Computer> computers) {
            for (int i = 0; i < connectInfo.length; i++) {
                if (i != number && connectInfo[i] == 1) {
                    connectComputer.add(computers.get(i));
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        List<Computer> computerList = generateNetwork(n, computers);
        boolean[] visited = new boolean[n];
        int answer = 0;
        int target = 0;
        while (target != n) {
            answer++;
            visited = visitNetwork(visited, computerList.get(target));
            target = findTarget(n, visited);
        }
        return answer;
    }

    private int findTarget(int n, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return i;
        }
        return n;
    }

    private boolean[] visitNetwork(boolean[] visited, Computer computer) {
        visited[computer.number] = true;
        for (Computer target: computer.connectComputer) {
            if (!visited[target.number]) {
                visited[target.number] = true;
                visited = visitNetwork(visited, target);
            }
        }
        return visited;
    }

    private List<Computer> generateNetwork(int n, int[][] computers) {
        List<Computer> computerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            computerList.add(new Computer(i));
        }
        for (int i = 0; i < n; i++) {
            computerList.get(i).connect(computers[i], computerList);
        }
        return computerList;
    }

    static private void grade(int result, int expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals) System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        network n = new network();

        int n1 = 3;
        int n2 = 3;

        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int expect1 = 2;
        int expect2 = 1;

        grade(n.solution(n1, computers1), expect1);
        grade(n.solution(n2, computers2), expect2);
    }
}

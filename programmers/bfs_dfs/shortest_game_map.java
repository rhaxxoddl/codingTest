package bfs_dfs;

import java.util.*;

public class shortest_game_map {
    static int[] v_d = {1, 0, -1, 0};
    static int[] h_d = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            visited[i] = new boolean[maps[i].length];
        }
        q.add(new int[]{0, 0, 1});
        return bfs(maps, visited);
    }

    private int bfs(int[][] maps, boolean[][] visited) {
        int[] currentPosition = q.poll();
        if (currentPosition == null)
            return -1;
        int x = currentPosition[0];
        int y = currentPosition[1];
        int count = currentPosition[2];
        if (y == maps.length - 1 && x == maps[maps.length - 1].length - 1)
            return count;
        for (int i = 0; i < 4; i++) {
            if (x + h_d[i] < 0
                    || y + v_d[i] < 0
                    || y + v_d[i] > maps.length - 1
                    || x + h_d[i] > maps[y + v_d[i]].length - 1)
                continue;
            if (maps[y + v_d[i]][x + h_d[i]] == 1 && !visited[y + v_d[i]][x + h_d[i]]) {
                visited[y + v_d[i]][x + h_d[i]] = true;
                q.add(new int[]{x + h_d[i], y + v_d[i], count + 1});
            }
        }
        return bfs(maps, visited);
    }

    static private void grade(int result, int expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals) System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        shortest_game_map s = new shortest_game_map();

        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        int[][] maps3 = {{1, 0}, {1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, 1}};

        int expect1 = 11;
        int expect2 = -1;
        int expect3 = 9;

        grade(s.solution(maps1), expect1);
        grade(s.solution(maps2), expect2);
        grade(s.solution(maps3), expect3);
    }
}

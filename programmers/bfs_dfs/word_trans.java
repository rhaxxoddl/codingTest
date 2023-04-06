package bfs_dfs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class word_trans {
    public int solution(String begin, String target, String[] words) {
        Queue<int[]> waitList = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (isMatchedIgnoreOneAlphabet(begin, words[i])){
                visited[i] = true;
                waitList.add(new int[]{i, 1});
            }
        }
        return bfs(target, words, visited, waitList);
    }

    private int bfs(String target, String[] words, boolean[] visited, Queue<int[]> waitList) {
        int[] current = waitList.poll();
        if (current == null)
            return 0;
        String currentWord = words[current[0]];
        int count = current[1];
        if (currentWord.equals(target))
            return count;
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isMatchedIgnoreOneAlphabet(currentWord, words[i])) {
                visited[i] = true;
                waitList.add(new int[]{i, count + 1});
            }
        }
        return bfs(target, words, visited, waitList);
    }

    private boolean isMatchedIgnoreOneAlphabet(String src, String target) {
        int count = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) != target.charAt(i))
                count++;
        }
        return count == 1;
    }
    static private void grade(int result, int expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals) System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        word_trans w = new word_trans();

        String begin1 = "hit";
        String begin2 = "hit";

        String target1 = "cog";
        String target2 = "cog";

        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        int expect1 = 4;
        int expect2 = 0;

        grade(w.solution(begin1, target1, words1), expect1);
        grade(w.solution(begin2, target2, words2), expect2);
    }
}

package complete_search;

import java.util.*;
import java.util.stream.Collectors;

public class fatigue {
    static public int solution(int k, int[][] dungeons) {
        List<List<Integer>> dungeon_list = Arrays.asList(dungeons).stream().map(array -> Arrays.stream(array).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        return adventure(k, dungeon_list, dungeon_list.size());
    }

    static private int adventure(int current_fatigue, List<List<Integer>> dungeons, int dungeon_init_size) {
        int max_clear = dungeon_init_size - dungeons.size();
        for (int i = 0; i < dungeons.size(); i++) {
            if (current_fatigue >= dungeons.get(i).get(0)) {
                List<List<Integer>> next_dungeons = new ArrayList<>(dungeons);
                next_dungeons.remove(i);
                max_clear = Math.max(max_clear,
                        adventure(current_fatigue - dungeons.get(i).get(1),
                                next_dungeons,
                                dungeon_init_size));
            }
        }
        return max_clear;
    }

    static private void grade(int result, int expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals) System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        int k1 = 80;

        int[][] dungeons1 = {{80, 20}, {50, 40}, {30, 10}};

        int expect1 = 3;

        grade(solution(k1, dungeons1), expect1);
    }
}

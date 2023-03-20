package hash;

import java.util.HashMap;
import java.util.Objects;

public class marathon {
    static private void grade(String result, String expect_result) {
        if (Objects.equals(result, expect_result))
            System.out.println("O");
        else
            System.out.println("X");
    }
    static public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String name: participant) {
            if (hash.containsKey(name)) {
                Integer num = hash.get(name);
                num++;
                hash.put(name, num);
            } else {
                hash.put(name, 1);
            }
        }
        for (String name: completion) {
            Integer value = hash.get(name);
            if (Objects.equals(value, 1)) {
                hash.remove(name);
            } else if (value > 1) {
                value--;
            }
        }
        String[] key = hash.keySet().toArray(new String[0]);
        if (key.length == 1)
            return key[0];
        else
            return null;
    }
    public static void main() {
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] participant4 = {"mislav", "stanko", "mislav", "ana"};

        String[] completion1 = {"eden", "kiki"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        String[] completion4 = {"mislav", "mislav", "ana"};

        String expect1 = "leo";
        String expect2 = "vinko";
        String expect3 = "mislav";
        String expect4 = "stanko";
        grade(solution(participant1, completion1), expect1);
        grade(solution(participant2, completion2), expect2);
        grade(solution(participant3, completion3), expect3);
        grade(solution(participant4, completion4), expect4);
    }
}

package hash;

import java.util.*;

public class camouflage {
    static public int solution(String[][] clothes) {
        Map<String, List<String>> clothes_map = new HashMap<>();
        for (String[] one_clothes: clothes) {
            if (clothes_map.containsKey(one_clothes[1])) {
                List<String> clothes_of_type = clothes_map.get(one_clothes[1]);
                clothes_of_type.add(one_clothes[0]);
                clothes_map.put(one_clothes[1], clothes_of_type);
            } else {
                List<String> clothes_of_type = new ArrayList<>();
                clothes_of_type.add(one_clothes[0]);
                clothes_map.put(one_clothes[1], clothes_of_type);
            }
        }
        int result = 1;
        for (String key: clothes_map.keySet()) {
            result *= clothes_map.get(key).size() + 1;
        }
        return result - 1;
    }
    static private void grade(Object result, Object expect_result) {
    if (Objects.equals(result, expect_result))
        System.out.println("O");
    else
        System.out.println("X");
}

    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
//        String[][] clothes3 = {"12", "123", "1235", "567", "88"};

        int expect1 = 5;
        int expect2 = 3;
//        int expect3 = false;
        grade(solution(clothes1), expect1);
        grade(solution(clothes2), expect2);
//        grade(solution(clothes3), expect3);
    }
}

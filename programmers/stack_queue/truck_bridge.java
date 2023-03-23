package stack_queue;

import java.util.*;
import java.util.stream.Collectors;

public class truck_bridge {
    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        List<List<Integer>> bridge = new ArrayList<>();
        int count = 0;
        int time = 0;
        while (count < truck_weights.length) {
            for (int i = 0; i < bridge.size(); i++) {
                bridge.get(i).set(1, bridge.get(i).get(1) + 1);
                if (bridge.get(i).get(1) >= bridge_length) {
                    bridge.remove(bridge.get(i));
                    count++;
                    i--;
                }

            }
            if (count + bridge.size() < truck_weights.length
                    && getCurrentWeight(bridge) + truck_weights[count + bridge.size()] <= weight
            && bridge.size() < bridge_length) {
                bridge.add(generateTruckWithPosition(truck_weights[count + bridge.size()]));
            }
            time++;
        }
        return time;
    }
    static private List<Integer> generateTruckWithPosition(int truck_weight) {
        List<Integer> truckWithPosition = new ArrayList<>();
        truckWithPosition.add(truck_weight);
        truckWithPosition.add(0);
        return truckWithPosition;
    }
    static private int getCurrentWeight(List<List<Integer>> bridge) {
        return bridge.stream().map(i -> i.get(0)).collect(Collectors.toList()).stream().mapToInt(i -> i).sum();
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
        int[] truck_weights1 = {7, 4, 5, 6};
        int[] truck_weights2 = {10};
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int bridge_length1 = 2;
        int bridge_length2 = 100;
        int bridge_length3 = 100;

        int weight1 = 10;
        int weight2 = 100;
        int weight3 = 100;

        int expect1 = 8;
        int expect2 = 101;
        int expect3 = 110;
        grade(solution(bridge_length1, weight1, truck_weights1), expect1);
        grade(solution(bridge_length2, weight2, truck_weights2), expect2);
        grade(solution(bridge_length3, weight3, truck_weights3), expect3);
    }
}

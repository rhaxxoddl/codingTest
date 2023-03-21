package hash;

import java.util.*;
import java.util.stream.Collectors;

public class bestAlbum {
    static public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playsOfJenreMap = generatePlaysOfJenreMap(genres, plays);
        HashMap<String, HashMap<Integer, Integer>> playsOfMusicMap = generatePlaysOfMusicMap(genres, plays);
        return generateBestAlbum(playsOfJenreMap, playsOfMusicMap);
    }

    static public HashMap<String, Integer> generatePlaysOfJenreMap(String[] jenres, int[] plays) {
        HashMap<String, Integer> playsOfJenre = new HashMap<>();
        for (int i = 0; i < jenres.length; i++) {
            Integer play = playsOfJenre.getOrDefault(jenres[i], 0);
            playsOfJenre.put(jenres[i], play + plays[i]);
        }
        return playsOfJenre;
    }

    static public HashMap<String, HashMap<Integer, Integer>> generatePlaysOfMusicMap(String[] jenres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> playsOfMusicMap = new HashMap<>();
        for (int i = 0; i < jenres.length; i++) {
            HashMap<Integer, Integer> playsOfMusic = playsOfMusicMap.get(jenres[i]);
            if (playsOfMusic == null)
                playsOfMusic = new HashMap<>();
            playsOfMusic.put(i, plays[i]);
            playsOfMusicMap.put(jenres[i], playsOfMusic);
        }
        return playsOfMusicMap;
    }

    static public int[] generateBestAlbum(HashMap<String, Integer> playsOfJenreMap, HashMap<String, HashMap<Integer, Integer>> playsOfMusicMap) {
        List<Integer> result = new ArrayList<>();
        List<String> jenresOrder = playsOfJenreMap
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue() - e1.getValue();
                })
                .map(e -> e.getKey()).collect(Collectors.toList());
        for (int j = 0; j < jenresOrder.size(); j++) {
            List<Map.Entry<Integer, Integer>> musicsOrder = playsOfMusicMap.get(jenresOrder.get(j))
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        return e2.getValue() - e1.getValue();
                    })
                    .collect(Collectors.toList());
            if (musicsOrder.size() >= 2) {
                if (musicsOrder.get(0).getValue().equals(musicsOrder.get(1).getValue())
                && musicsOrder.get(0).getKey() > musicsOrder.get(1).getKey()) {
                    result.add(musicsOrder.get(1).getKey());
                    result.add(musicsOrder.get(0).getKey());
                } else {
                    result.add(musicsOrder.get(0).getKey());
                    result.add(musicsOrder.get(1).getKey());
                }
            } else if (musicsOrder.size() == 1) {
                result.add(musicsOrder.get(0).getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    static private void grade(int[] result, int[] expect_result) {
        if (Objects.equals(result, expect_result))
            System.out.println("O");
        else {
            System.out.println("X");
            System.out.println("expected result: " + expect_result);
            System.out.println("your result: " + result);
        }
    }

    public static void main(String[] args) {
        String[] jenres1 = {"classic", "pop", "classic", "classic", "pop"};

        int[] plays1 = {500, 600, 150, 800, 2500};
        int[] expect1 = {4, 1, 3, 0};
        grade(solution(jenres1, plays1), expect1);
    }

}

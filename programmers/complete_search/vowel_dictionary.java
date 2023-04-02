package complete_search;

import java.util.Objects;

public class vowel_dictionary {
    static public int solution(String word) {
        StringBuilder word_builder = new StringBuilder("A");
        int answer = 1;
        while (!word.equals(word_builder.toString())) {
            word_builder = next_word(word_builder);
            answer++;
        }
        return answer;
    }

    static private StringBuilder next_word(StringBuilder word) {
        if (word.length() < 5) {
            word.append('A');
        } else {
            String next = "";
            while (next.equals("")){
                next = next_alpha(word.charAt(word.length() - 1));
                word.replace(word.length() - 1, word.length(), next);
            }
        }
        return word;
    }

    static private String next_alpha(char c) {
        String char_set = "AEIOU";
        for (int i = 0; i < char_set.length(); i++) {
            if (char_set.charAt(i) == c) {
                i++;
                if (i < char_set.length())
                    return char_set.substring(i, i + 1);
                else
                    return "";
            }
        }
        return "";
    }

    static private void grade(int result, int expect_result) {
        Boolean equals = Objects.equals(result, expect_result);
        if (equals) System.out.println("O");
        else {
            System.out.println("X");
        }
    }

    public static void main(String[] args) {
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        int expect1 = 6;
        int expect2 = 10;
        int expect3 = 1563;
        int expect4 = 1189;

        grade(solution(word1), expect1);
        grade(solution(word2), expect2);
        grade(solution(word3), expect3);
        grade(solution(word4), expect4);
    }
}

package hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class phonebook {
    public static boolean solution(String[] phone_book) {
        List<String> phone_book_list = Arrays.asList(phone_book);
        phone_book_list.sort(Comparator.naturalOrder());
        for (int i = 0; i < phone_book_list.size(); i++) {
            if (i < phone_book_list.size() - 1) {
                if (phone_book_list.get(i + 1).startsWith(phone_book_list.get(i)))
                    return false;
            }
        }
        return true;
    }

    static private void grade(Object result, Object expect_result) {
        if (Objects.equals(result, expect_result))
            System.out.println("O");
        else
            System.out.println("X");
    }

    public static void main(String[] args) {
        String[] participant1 = {"119", "97674223", "1195524421"};
        String[] participant2 = {"123", "456", "789"};
        String[] participant3 = {"12", "123", "1235", "567", "88"};

        boolean expect1 = false;
        boolean expect2 = true;
        boolean expect3 = false;
        grade(solution(participant1), expect1);
        grade(solution(participant2), expect2);
        grade(solution(participant3), expect3);
    }
}

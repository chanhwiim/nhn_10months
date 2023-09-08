package day0908;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static double correctCount = 0;

    private static final String[][] TESTCASES = new String[][] {
            { "123", "123", "246" },
            { "1000", "1", "2" },
            { "456", "789", "1461" },
            { "5", "5", "1" },
            { "11112", "54321", "65433" },
            { "3829", "1300", "4139" }
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        int first = Integer.parseInt(input);
        int second = Integer.parseInt(input2);

        boolean res = String.valueOf(solution(first, second)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }

    // private static char[] solution(int first, int second) {
    // List list = new ArrayList<>();
    // int result = 0;

    // return null;
    // } 폐기

    private static int solution(int first, int second) {
        int first_reverse = 0;
        int second_reverse = 0;
        int result_reverse = 0;
        int first_rem;
        int second_rem;
        int result_rem;

        int result;

        while (first > 0 || second > 0) {
            if (first > 0) {
                first_rem = first % 10;
                first_reverse = (first_reverse * 10) + first_rem;
                first = first / 10;
            } else if (second > 0) {
                second_rem = second % 10;
                second_reverse = (second_reverse * 10) + second_rem;
                second = second / 10;
            }
        }

        // while (first > 0) {
        // first_rem = first % 10;
        // first_reverse = (first_reverse * 10) + first_rem;
        // first = first / 10;
        // }

        // while (second > 0) {
        // second_rem = second % 10;
        // second_reverse = (second_reverse * 10) + second_rem;
        // second = second / 10;

        // }
        result = first_reverse + second_reverse;

        while (result > 0) {
            result_rem = result % 10;
            result_reverse = (result_reverse * 10) + result_rem;
            result = result / 10;
        }

        System.out.println(result_reverse);

        return result_reverse;
    }

}
package day0905;

import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int[] input = { 0, 3, 2, 624, 339, 13, 45232 };
        String[] output = { "0", "11", "10", "1001110000", "101010011", "1101", "1011000010110000" };

        System.out.printf("Out of %d Cases, %1.0f were correct", input.length, test(input, output));
    }

    public static double test(int[] input, String[] output) {
        double score = 0;

        for (int i = 0; i < input.length; i++) {
            System.out.printf("Case %d %n", i);

            String correct = output[i];
            System.out.printf("Input : %d \t -> Expected : %s %n", input[i], output[i]);

            String str = solution(input[i]);
            System.out.printf("Your Answer : %s %n", str);

            if (str.equals(correct)) {
                score++;
            }
        }

        return score;
    }

    private static String solution(int i) {
        List<Integer> list = new LinkedList();
        int remain;

        while (i != 0) {
            remain = i % 2;
            list.add(0, i % 2);
            i /= 2;
        }

        StringBuilder s = new StringBuilder();
        for (int digit : list) {
            s.append(digit);
        }

        return s.toString();
        // String answer = "";

        // do {
        // answer = (i % 2) + answer;
        // i /= 2;
        // } while (i > 0);
        // return answer;
    }
}
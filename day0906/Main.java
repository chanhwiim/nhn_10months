package day0906;

public class Main {

    private static final String[] TEST_CASE_KEYS = {
            "00000001",
            "101",
            "1011",
            "111000",
            "1011111",
            "1111111111111",
            "00111001110001111100001"
    };

    private static final int[] TEST_CASE_VALUES = {
            1,
            5,
            11,
            56,
            95,
            8191,
            1893345
    };

    private static double correct = 0;

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASE_KEYS.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASE_KEYS[i], TEST_CASE_VALUES[i]));
        }

        System.out.printf("정답률 = %.3f%%", (correct / TEST_CASE_KEYS.length * 100));
    }

    private static boolean test(String input, Integer result) {
        if (solution2(input) == result) {
            correct++;
            return true;
        }

        return false;
    }

    private static int solution(String input) {
        // int answer = 0;

        // int[] array = new int[input.length()];

        // for (int i = array.length - 1; i > 0; i--)
        // answer += Math.pow(2, i);

        // System.out.println(answer);
        // System.out.println(array.length);
        // return answer;
        // => 내가 만들던거. 계산도 이상하고, 자릿수도 이상하다. 0도 계산을 해버리는 것처럼 보인다. array의 길이만큼 n승 해서 그런듯
        // 하다. 그냥 int[]를 잘못 쓴듯. 조용히 char[] 쓸껄

        char[] array = input.toCharArray();
        int result = 0;

        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            result += (array[i] - 48) * Math.pow(2, j); // ascii version
        } // array[i] - 48 => 0, 1
        System.out.println(result);
        return result;
    }

    private static int solution2(String input) {
        int answer = 0;

        char[] array = input.toCharArray();

        for (int i = array.length - 1, j = 0; i >= 0; i--, j++)
            answer += (array[i] - 48) * Math.pow(2, j);

        System.out.println(answer);
        System.out.println(array.length);
        return answer;
    }

}
package day0907;

import java.util.Arrays;

public class Main {

    private static final int[] TESTCASES = { 4, 5, 10 };

    private static final int[][][] TESTCASES_RESULT = {
            {
                    { 1, 2, 3, 4 },
                    { 12, 13, 14, 5 },
                    { 11, 16, 15, 6 },
                    { 10, 9, 8, 7 }
            },
            {
                    { 1, 2, 3, 4, 5 },
                    { 16, 17, 18, 19, 6 },
                    { 15, 24, 25, 20, 7 },
                    { 14, 23, 22, 21, 8 },
                    { 13, 12, 11, 10, 9 }
            },
            {
                    { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                    { 36, 37, 38, 39, 40, 41, 42, 43, 44, 11 },
                    { 35, 64, 65, 66, 67, 68, 69, 70, 45, 12 },
                    { 34, 63, 84, 85, 86, 87, 88, 71, 46, 13 },
                    { 33, 62, 83, 96, 97, 98, 89, 72, 47, 14 },
                    { 32, 61, 82, 95, 100, 99, 90, 73, 48, 15 },
                    { 31, 60, 81, 94, 93, 92, 91, 74, 49, 16 },
                    { 30, 59, 80, 79, 78, 77, 76, 75, 50, 17 },
                    { 29, 58, 57, 56, 55, 54, 53, 52, 51, 18 },
                    { 28, 27, 26, 25, 24, 23, 22, 21, 20, 19 }
            }
    };

    private static double correct = 0;

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Test Case " + (i + 1) + " = " + test(TESTCASES[i], TESTCASES_RESULT[i]));

        System.out.println("정답률 = " + (int) (correct / TESTCASES.length * 100) + "%");
    }

    private static boolean test(int input, int[][] result) {
        if (Arrays.deepEquals(solution(input), result)) {
            correct++;
            return true;
        }
        return false;
    }

    // private static int[][] solution(int input) {
    // int printNum = 1;
    // int[][] twoDimensionalArray = new int[input][input];
    // int x = -1;
    // int y = 0;

    // for(int i = input; i > 0; i--){
    // for (int j = 0; j < input; j++){
    // x ++;
    // twoDimensionalArray[y][x] = printNum++;
    // }
    // }
    // return twoDimensionalArray;
    // }

    private static int[][] solution(int input) {
        int[][] answer = new int[input][input];
        int number = 1;
        int x = -1; // 인덱스의 시작이 -1인 이유는? => 배열의 첫 번째 열에서 시작하기 때문에. 0으로 하면 열의 두 번째부터 시작된다. 맞겠지.
        int y = 0; // 여기가 0인 이유는? 이미 x가 돌아서 맨 앞칸이 채워졌기 때문인가? y를 먼저 채우면 얘가 -1이 되겠지?
        int direction = 1;

        while (input > 0) {
            for (int i = 0; i < input; i++) {
                x += direction; // 오른쪽으로 1칸씩
                answer[y][x] = number++;
            }
            input--;

            for (int i = 0; i < input; i++) {
                y += direction;
                answer[y][x] = number++;
            }
            direction *= -1;
        }

        return answer;
    }
}
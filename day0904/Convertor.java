package day0904;

public class Convertor {
    private static double correctCount = 0;
    private static final String[][] TESTCASES = new String[][] {
            { "MANGO", "mango" },
            { "peach", "PEACH" },
            { "Apple", "aPPLE" },
            { "baNANa", "BAnanA" },
            { "Believe In YourSelF", "bELIEVE iN yOURsELf" },
            { "THiS is how LIFE is!!", "thIs IS HOW life IS!!" },
            { "Li^^ve  p$osi&TIVE*", "lI^^VE  P$OSI&tive*" },
            { "%tiMe~~~~ iS>.< gggggolD ?:)", "%TImE~~~~ Is>.< GGGGGOLd ?:)" }
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1]));

        System.out.println("정답률 = " + (int) (correctCount / 8 * 100) + "%");
    }

    private static boolean test(String input, String answer) {
        boolean res = solution(input).equals(answer);
        if (res)
            correctCount++;
        return res;
    }

    // solution
    public static String solution(String input) {
        // int tmp;
        // String output = "";

        // for (int i = 0; i < input.length(); i++) {
        // tmp = (int) input.charAt(i);
        // if (65 <= tmp && tmp <= 90) {
        // // input.charAt(i) += 32;
        // // tmp += 32;
        // output += (char) (tmp + 32);
        // }

        // else if (97 <= tmp && tmp <= 122) {
        // output += (char) (tmp - 32);
        // }

        // }
        // System.out.println(output);
        // return output;

        char[] array = input.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 65 && array[i] <= 90) {
                array[i] += 32;
            } else if (array[i] >= 97 && array[i] <= 122) {
                array[i] -= 32;
            }
        }
        System.out.println(String.valueOf(array));

        return String.valueOf(array);
    }
}
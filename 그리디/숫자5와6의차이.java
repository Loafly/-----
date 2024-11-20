package 그리디;

import java.util.Scanner;

public class 숫자5와6의차이 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        // 최소, 최대 값 계산
        int[] resultA = transform(a);
        int[] resultB = transform(b);

        // 최소와 최대 합 계산
        int minSum = resultA[0] + resultB[0];
        int maxSum = resultA[1] + resultB[1];

        System.out.println(minSum + " " + maxSum);
    }

    // 숫자를 최소와 최대값으로 변환하는 함수
    public static int[] transform(String num) {
        StringBuilder minNum = new StringBuilder();
        StringBuilder maxNum = new StringBuilder();

        for (char ch : num.toCharArray()) {
            if (ch == '5' || ch == '6') {
                minNum.append('5');
                maxNum.append('6');
            } else {
                minNum.append(ch);
                maxNum.append(ch);
            }
        }

        return new int[] { Integer.parseInt(minNum.toString()), Integer.parseInt(maxNum.toString()) };
    }
}

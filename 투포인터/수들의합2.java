package 투포인터;

import java.util.Scanner;

class 수들의합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 배열 길이
        int m = sc.nextInt(); // 목표 값
        int[] arrays = new int[n];

        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }

        int startIndex = 0;
        int endIndex = 0;
        int currentSum = arrays[startIndex];
        int answer = 0;

        while (true) {
            if (startIndex >= n) {
                break;
            }

            if (arrays[endIndex] >= m) {
                if (arrays[endIndex] == m) {
                    answer++;
                }

                if (endIndex < n - 1) {
                    endIndex++;
                    startIndex = endIndex;
                    currentSum = arrays[endIndex];
                    continue;
                } else {
                    break;
                }
            }

            if (currentSum < m) {
                endIndex++;
                if (endIndex >= n) {
                    break;
                }
                currentSum += arrays[endIndex];
            } else if (currentSum > m) {
                currentSum -= arrays[startIndex];
                startIndex++;
            } else if (currentSum == m) {
                answer++;
                currentSum -= arrays[startIndex];
                startIndex++;
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
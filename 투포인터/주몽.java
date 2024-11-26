package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arrays = new int[n];

        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextInt();
        }

        // 배열 정렬
        Arrays.sort(arrays);

        int answer = 0;
        int s = 0;
        int e = n - 1;

        // 투 포인터 알고리즘
        while (s < e) {
            int currentValue = arrays[s] + arrays[e];

            if (currentValue == m) {
                s++;
                e--;
                answer++;
            } else if (currentValue > m) {
                e--;
            } else { // currentValue < m
                s++;
            }
        }

        System.out.println(answer);
    }
}

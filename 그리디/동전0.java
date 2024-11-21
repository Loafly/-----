package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 동전0 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n과 k 입력받기
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // 동전 배열 입력받기
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // 내림차순 정렬
        Arrays.sort(coins);
        for (int i = 0; i < n / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[n - 1 - i];
            coins[n - 1 - i] = temp;
        }

        int count = 0;

        // 동전 개수 계산
        for (int coin : coins) {
            count += k / coin;
            k %= coin;

            if (k == 0) {
                break;
            }
        }

        // 결과 출력
        System.out.println(count);
        scanner.close();
    }
}
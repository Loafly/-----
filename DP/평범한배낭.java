package DP;

import java.util.Scanner;

public class 평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n: 물건의 개수, k: 최대 무게
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[k + 1]; // DP 배열 초기화
        int[][] items = new int[n][2]; // 물건의 무게와 가치를 저장할 배열

        // 물건의 무게와 가치 입력
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt(); // 무게
            int v = sc.nextInt(); // 가치
            items[i][0] = w;
            items[i][1] = v;
        }

        // 배낭 알고리즘
        for (int i = 0; i < n; i++) {
            int w = items[i][0];
            int v = items[i][1];
            for (int j = k; j >= w; j--) { // 거꾸로 계산
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        // 결과 출력
        System.out.println(dp[k]);
        sc.close();
    }
    
}

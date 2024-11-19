package DP;

import java.util.HashMap;
import java.util.Scanner;

public class 피보나치수2 {
        // DP를 저장할 HashMap
    static HashMap<Integer, Integer> dp = new HashMap<>();

    // 초기 DP 값 설정
    static {
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 1);
    }

    // 재귀 방식의 피보나치 함수
    public static void fibonacci(int n) {
        if (dp.containsKey(n)) {
            return; // 이미 계산된 값이면 종료
        }

        if (!dp.containsKey(n - 1)) {
            fibonacci(n - 1); // n-1 계산
        }

        dp.put(n, dp.get(n - 1) + dp.get(n - 2)); // DP 저장
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fibonacci(n); // 피보나치 계산
        System.out.println(dp.get(n)); // 결과 출력
        sc.close();
    }
}

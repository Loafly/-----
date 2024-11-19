package 그리디;

import java.util.Scanner;

public class 거스름돈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        scanner.close();

        // 동전 배열과 초기 변수 설정
        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;

        // 거스름돈 계산
        int rest = 1000 - n;

        for (int coin : coins) {
            count += rest / coin;
            rest = rest % coin;
        }

        // 결과 출력
        System.out.println(count);
    }
}

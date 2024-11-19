package DP;

import java.util.Scanner;

public class 부녀회장이될테야 {
    public static void solved(int floor, int ho, int[][] arrays) {
        if (ho == 1) {
            arrays[floor][ho] = 1; // 호가 1일 때, 1로 설정
            return;
        }

        if (floor == 0) {
            arrays[floor][ho] = ho; // 0층은 호 번호와 동일
            return;
        }

        if (arrays[floor - 1][ho] == 0) {
            solved(floor - 1, ho, arrays); // 아래층 값이 계산되지 않았다면 계산
        }

        if (arrays[floor][ho - 1] == 0) {
            solved(floor, ho - 1, arrays); // 왼쪽 호 값이 계산되지 않았다면 계산
        }

        arrays[floor][ho] = arrays[floor - 1][ho] + arrays[floor][ho - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); // 테스트 케이스 개수 입력

        for (int i = 0; i < k; i++) {
            int floor = sc.nextInt(); // 층수 입력
            int ho = sc.nextInt();    // 호수 입력

            int[][] arrays = new int[floor + 1][ho + 1]; // 배열 초기화

            solved(floor, ho, arrays);
            System.out.println(arrays[floor][ho]); // 결과 출력
        }

        sc.close();
    }
    
}

package 투포인터;

import java.util.Scanner;

public class 부분합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }

        // 변수 초기화
        int startIndex = 0;
        int currentSum = 0;
        int answer = Integer.MAX_VALUE;

        // 슬라이딩 윈도우 시작
        for (int endIndex = 0; endIndex < n; endIndex++) {
            currentSum += arrays[endIndex];

            while (currentSum >= s) {
                int length = endIndex - startIndex + 1;
                answer = Math.min(answer, length);
                currentSum -= arrays[startIndex];
                startIndex++;
            }
        }

        // 결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}

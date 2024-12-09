package 슬라이딩윈도우;

import java.util.Scanner;

public class 꿀아르바이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }
        
        // 현재월급과 최대월급 초기화
        int 현재월급 = 0;
        int 최대월급 = 0;
        
        // 처음 m개의 합 계산
        for (int i = 0; i < m; i++) {
            현재월급 += arrays[i];
        }
        최대월급 = 현재월급;
        
        // 슬라이딩 윈도우로 최대월급 계산
        for (int i = m; i < n; i++) {
            현재월급 = 현재월급 + arrays[i] - arrays[i - m];
            최대월급 = Math.max(최대월급, 현재월급);
        }
        
        // 결과 출력
        System.out.println(최대월급);
    }
}

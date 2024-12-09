package 슬라이딩윈도우;

import java.util.Scanner;

public class 블로그 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }

        // 변수 초기화
        int 현재방문자수 = 0;
        int 최대방문자수 = 0;
        int 최대방문자수반복횟수 = 1;

        // 처음 m개의 합 계산
        for (int i = 0; i < m; i++) {
            현재방문자수 += arrays[i];
        }
        최대방문자수 = 현재방문자수;

        // 슬라이딩 윈도우로 최대방문자수 계산
        for (int i = m; i < n; i++) {
            현재방문자수 = 현재방문자수 + arrays[i] - arrays[i - m];

            if (최대방문자수 == 현재방문자수) {
                최대방문자수반복횟수++;
            } else if (최대방문자수 < 현재방문자수) {
                최대방문자수 = 현재방문자수;
                최대방문자수반복횟수 = 1;
            }
        }

        // 결과 출력
        if (최대방문자수 == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(최대방문자수);
            System.out.println(최대방문자수반복횟수);
        }
    }
}

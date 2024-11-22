package 그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 카드 묶음의 개수 입력
        int n = scanner.nextInt();

        // 우선순위 큐 생성
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        // 카드 묶음 입력
        for (int i = 0; i < n; i++) {
            int card = scanner.nextInt();
            cards.add(card);
        }

        int answer = 0;

        while (true) {
            // 가장 작은 카드 묶음 꺼내기
            int card1 = cards.poll();

            // 큐가 비었으면 결과 출력 후 종료
            if (cards.isEmpty()) {
                System.out.println(answer);
                break;
            }

            // 두 번째로 작은 카드 묶음 꺼내기
            int card2 = cards.poll();

            // 두 카드 묶음을 합치고 다시 큐에 넣기
            int sumCard = card1 + card2;
            cards.add(sumCard);
            answer += sumCard;
        }

        scanner.close();
    }
}

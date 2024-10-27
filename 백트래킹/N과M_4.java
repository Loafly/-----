import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N과M_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();
        
        backtrack(N, M, 1, new ArrayList<>());
    }
    
    public static void backtrack(int n, int m, int start, List<Integer> sequence) {
        // 길이가 m인 수열을 찾으면 출력
        if (sequence.size() == m) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        // start부터 n까지의 숫자를 순회
        for (int i = start; i <= n; i++) {
            // 현재 선택한 숫자를 수열에 추가하고, 다음 단계로 이동
            sequence.add(i);
            backtrack(n, m, i, sequence);
            // 백트래킹 단계: 마지막으로 추가한 숫자를 제거
            sequence.remove(sequence.size() - 1);
        }
    }
}
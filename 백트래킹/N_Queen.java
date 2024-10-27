import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N_Queen {
    private static int n;
    private static Set<Integer> columns = new HashSet<>();  // 같은 열에 퀸이 있는지 확인
    private static Set<Integer> diag1 = new HashSet<>();    // 왼쪽 대각선 (\) 확인
    private static Set<Integer> diag2 = new HashSet<>();    // 오른쪽 대각선 (/) 확인

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();

        System.out.println(backtrack(0));
    }

    public static int backtrack(int row) {
        // N개의 퀸을 모두 배치한 경우
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (!columns.contains(col) && !diag1.contains(row - col) && !diag2.contains(row + col)) {
                // 퀸 배치 가능, 위치를 추가
                columns.add(col);
                diag1.add(row - col);
                diag2.add(row + col);

                // 다음 행으로 이동
                count += backtrack(row + 1);

                // 백트래킹: 현재 위치에서 퀸 제거
                columns.remove(col);
                diag1.remove(row - col);
                diag2.remove(row + col);
            }
        }
        return count;
    }
}


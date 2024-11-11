import java.util.ArrayList;
import java.util.Scanner;

public class 사다리조작 {
    static int N, M, H, CNT;
    static int[][] arr;
    static ArrayList<int[]> pos;
    static int ans;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); // 세로선의 개수
        M = sc.nextInt(); // 주어진 가로선의 개수
        H = sc.nextInt(); // 가로선을 놓을 수 있는 높이의 개수
        
        arr = new int[H + 1][N + 2]; // 배열 초기화 (좌우에 공백 추가)
        
        // [1] 미리 놓아진 가로선 입력
        for (int i = 0; i < M; i++) {
            int ti = sc.nextInt();
            int tj = sc.nextInt();
            arr[ti][tj] = 1; // 가로선이 있는 위치 표시
        }
        
        // [2] 가로선을 추가할 후보 위치 저장
        pos = new ArrayList<>();
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0 && arr[i][j - 1] == 0 && arr[i][j + 1] == 0) {
                    pos.add(new int[]{i, j});
                }
            }
        }
        
        CNT = pos.size();
        
        // [3] 추가할 가로선 개수를 0부터 3까지 실행, 불가능하면 -1 출력
        for (cnt = 0; cnt <= 3; cnt++) {
            ans = 0;
            backtrack(0, 0);
            if (ans == 1) {
                System.out.println(cnt);
                return;
            }
        }
        
        System.out.println(-1);
    }

    // 모든 세로선이 시작 위치와 동일한 위치에 도착하는지 확인하는 함수
    static int check() {
        for (int sj = 1; sj <= N; sj++) {
            int j = sj;
            for (int i = 1; i <= H; i++) {
                if (arr[i][j] == 1) { // 오른쪽으로 이동
                    j++;
                } else if (j > 1 && arr[i][j - 1] == 1) { // 왼쪽으로 이동
                    j--;
                }
            }
            if (j != sj) {
                return 0; // 하나라도 다르면 실패
            }
        }
        return 1;
    }

    // 가로선을 추가하면서 모든 가능한 경우를 백트래킹으로 탐색
    static void backtrack(int n, int s) {
        if (ans == 1) {
            return; // 이미 답을 찾으면 더 이상 진행하지 않음
        }

        if (n == cnt) { // 필요한 개수의 가로선을 모두 선택했을 때
            if (check() == 1) {
                ans = 1;
            }
            return;
        }

        for (int j = s; j < CNT; j++) {
            int[] position = pos.get(j);
            int ti = position[0];
            int tj = position[1];
            
            // 왼쪽과 오른쪽에 가로선이 없는 경우만 가로선 추가 가능
            if (arr[ti][tj - 1] == 0 && arr[ti][tj + 1] == 0) {
                arr[ti][tj] = 1; // 가로선 추가
                backtrack(n + 1, j + 1); // 다음 가로선 위치로 진행
                arr[ti][tj] = 0; // 가로선 제거 (백트래킹)
            }
        }
    }
}
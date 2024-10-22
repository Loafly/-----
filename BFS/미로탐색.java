package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
    static int N, M;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        graph = new int[N][M];

        // 그래프 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            // 상하좌우 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나면 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 벽이 아니고 방문하지 않은 곳이라면
                if (graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    graph[nx][ny] = graph[x][y] + 1;
                }
            }
        }

        return graph[N - 1][M - 1];
    }
}
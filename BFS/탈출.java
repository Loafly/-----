package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {
    static int N, M;
    static char[][] graph;
    static int[][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int Dx, Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        graph = new char[N][M];
        distance = new int[N][M];

        // 그래프 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            graph[i] = line.toCharArray();
        }

        // 비버 집과 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 'D') {
                    Dx = i;
                    Dy = j;
                } else if (graph[i][j] == 'S') {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 물의 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == '*') {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 결과 출력
        String result = bfs(Dx, Dy);
        System.out.println(result);
    }

    public static String bfs(int Dx, int Dy) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 비버의 집에 도착한 경우
            if (graph[Dx][Dy] == 'S') {
                return String.valueOf(distance[Dx][Dy]);
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어난 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 비버의 움직임 처리
                if ((graph[nx][ny] == '.' || graph[nx][ny] == 'D') && graph[x][y] == 'S') {
                    distance[nx][ny] = distance[x][y] + 1;
                    graph[nx][ny] = 'S';
                    queue.add(new int[]{nx, ny});
                }
                // 물의 움직임 처리
                else if ((graph[nx][ny] == '.' || graph[nx][ny] == 'S') && graph[x][y] == '*') {
                    graph[nx][ny] = '*';
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // 비버의 집에 도달하지 못한 경우
        return "KAKTUS";
    }
}

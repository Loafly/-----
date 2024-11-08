import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class 스도쿠 {
    static int[][] arrays = new int[9][9];
    static ArrayList<int[]> emptyCells = new ArrayList<>();
    
    static HashSet<Integer>[] rows = new HashSet[9];
    static HashSet<Integer>[] columns = new HashSet[9];
    static HashSet<Integer>[] boxes = new HashSet[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 각 행, 열, 3x3 박스의 중복 체크용 집합 초기화
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // 보드 입력 및 빈 칸 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arrays[i][j] = scanner.nextInt();
                if (arrays[i][j] == 0) {
                    emptyCells.add(new int[]{i, j});
                } else {
                    int num = arrays[i][j];
                    rows[i].add(num);
                    columns[j].add(num);
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    boxes[boxIndex].add(num);
                }
            }
        }

        scanner.close();

        // 백트래킹 시작
        if (backtrack(0)) {
            printBoard();
        } else {
            System.out.println("해결할 수 없는 스도쿠 문제입니다.");
        }
    }

    static boolean backtrack(int index) {
        if (index == emptyCells.size()) {
            return true;
        }

        int[] cell = emptyCells.get(index);
        int i = cell[0];
        int j = cell[1];
        int boxIndex = (i / 3) * 3 + (j / 3);

        for (int k = 1; k <= 9; k++) {
            if (!rows[i].contains(k) && !columns[j].contains(k) && !boxes[boxIndex].contains(k)) {
                arrays[i][j] = k;
                rows[i].add(k);
                columns[j].add(k);
                boxes[boxIndex].add(k);

                if (backtrack(index + 1)) {
                    return true;
                }

                arrays[i][j] = 0;
                rows[i].remove(k);
                columns[j].remove(k);
                boxes[boxIndex].remove(k);
            }
        }

        return false;
    }

    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }
}
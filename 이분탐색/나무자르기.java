import java.util.*;

public class 나무자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N and M
        int N = sc.nextInt();
        int M = sc.nextInt();

        // Read the tree heights
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }

        // Binary search to find the maximum height
        int min_value = 0;
        int max_value = Arrays.stream(trees).max().getAsInt();

        while (min_value <= max_value) {
            int mid_value = (min_value + max_value) / 2;
            long current_sum_value = 0;

            for (int tree : trees) {
                if (tree > mid_value) {
                    current_sum_value += (tree - mid_value);
                }
            }

            if (current_sum_value >= M) {
                min_value = mid_value + 1;
            } else {
                max_value = mid_value - 1;
            }
        }

        System.out.println(max_value);
    }
}
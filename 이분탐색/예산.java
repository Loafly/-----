import java.util.*;

public class 예산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N
        int N = sc.nextInt();

        // Read the array of integers
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        // Read M
        int M = sc.nextInt();

        // Binary search to find the maximum possible value
        int min_value = 0;
        int max_value = Arrays.stream(array).max().getAsInt();

        while (min_value <= max_value) {
            int mid_value = (min_value + max_value) / 2;
            long sum_value = 0;

            for (int value : array) {
                if (value > mid_value) {
                    sum_value += mid_value;
                } else {
                    sum_value += value;
                }
            }

            if (sum_value > M) {
                max_value = mid_value - 1;
            } else {
                min_value = mid_value + 1;
            }
        }

        System.out.println(max_value);
    }
}
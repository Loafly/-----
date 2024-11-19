package DP;

import java.util.HashMap;
import java.util.Scanner;

public class 계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n + 1];
        HashMap<Integer, Integer> dp = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            array[i] = sc.nextInt();

            if (i == 1) {
                dp.put(i, array[i]);
            } else if (i == 2) {
                dp.put(i, dp.get(i - 1) + array[i]);
            } else if (i == 3) {
                dp.put(i, Math.max(dp.get(i - 2) + array[i], array[i - 1] + array[i]));
            }
        }

        if (n > 3) {
            for (int i = 4; i <= n; i++) {
                dp.put(i, Math.max(dp.get(i - 3) + array[i - 1], dp.get(i - 2)) + array[i]);
            }
        }

        System.out.println(dp.get(n));
        sc.close();
    }
}

package 투포인터;

import java.util.Scanner;

public class 수들의합5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int startNum = 1;
        int lastNum = 1;
        int count = 0;
        int currentSum = 1;

        while (true) {
            if (currentSum < n && lastNum >= n + 1) {
                break;
            }

            if (currentSum < n) {
                lastNum++;
                currentSum += lastNum;
            } else if (currentSum > n) {
                currentSum -= startNum;
                startNum++;
            } else if (currentSum == n) {
                count++;
                currentSum -= startNum;
                startNum++;
            }
        }

        System.out.println(count);
    }
}
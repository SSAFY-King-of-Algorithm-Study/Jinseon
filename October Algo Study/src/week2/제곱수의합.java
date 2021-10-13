package week2;

import java.util.Scanner;

public class 제곱수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        int powNum = 1;
        for(int i = 1; i <= N; i++){
            if(i == Math.pow(powNum, 2)){
                dp[i] = 1;
                powNum++;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= i/2; j++){
                min = Math.min(dp[j] + dp[i - j], min);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);

    }
}

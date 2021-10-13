package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 학년1 {
    static int N, answer, cnt;
    static int[] nums;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N - 1];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N - 1; i++)
            nums[i] = Integer.parseInt(temp[i]);
        answer = Integer.parseInt(temp[N-1]);

        dfs(0, 0);
        System.out.println(cnt);
    }

    private static void dfs(int result, int i) {
        if(result < 0 || result > 20) return;

        if(i == N - 1){
            if(result == answer) cnt++;
            return;
        }

        dfs(result + nums[i], i + 1);
        dfs(result - nums[i], i + 1);
    }
}

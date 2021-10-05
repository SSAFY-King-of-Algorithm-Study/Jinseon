package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 게리맨더링 {
    static int N;
    static int[] population;
    static int[][] adj;
    static int[] numbersA, numbersB;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        input();

        for(int r = 1; r <= N / 2; r++) {
            numbersA = new int[r];
            numbersB = new int[N - r];
            combination(0, 0, r);
        }

        System.out.println(min);
    }

    private static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 구역의 개수
        N = Integer.parseInt(br.readLine());
        // 인구 수 입력 (배열)
        population = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            population[i] = Integer.parseInt(temp[i]);
        // 인접 리스트 입력 (2차원 배열)
        adj = new int[N][];
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            int len = Integer.parseInt(temp[0]);
            adj[i] = new int[len];
            for(int j = 1; j <= len; j++)
                adj[i][j-1] = Integer.parseInt(temp[j]);
        }

        visited = new boolean[N];
    }

    private static void combination(int cnt, int start, int r) {
        if (cnt == r) {
            // 다른 선거구 구하기
            Arrays.sort(numbersA);
            int a = 0, b = 0;
            for(int i = 0; i < N; i++){
                if(i == numbersA[a]) a++;
                else numbersB[b++] = i;
            }
            // 두 선거구가 올바르게 인접했는지 확인 -> 올바르면 인구수 최소값 구하기
            if(isAdjacent_dfs(numbersA, numbersA[0]) && isAdjacent_dfs(numbersB, numbersB[0]))
                min = Math.min(min, getPopulationDiff());
            return;
        }
        for (int i = start; i < N; i++) {
            numbersA[cnt] = i;
            combination(cnt + 1, i + 1, r);
        }
    }

    private static int getPopulationDiff() {
        int popA = 0, popB = 0;
        for(int i = 0; i < numbersA.length; i++)
            popA += population[numbersA[i]];
        for(int i = 0; i < numbersB.length; i++)
            popB += population[numbersB[i]];
        return Math.abs(popA - popB);
    }

    private static boolean isAdjacent_dfs(int[] arr, int cur){
        visited[cur] = true;

        for(int i = 0; i < adj[cur].length; i++){

        }
        return true;
    }
}

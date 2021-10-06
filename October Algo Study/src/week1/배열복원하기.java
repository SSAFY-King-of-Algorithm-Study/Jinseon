package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 배열복원하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int H = Integer.parseInt(temp[0]);
        int W = Integer.parseInt(temp[1]);
        int X = Integer.parseInt(temp[2]);
        int Y = Integer.parseInt(temp[3]);
        int[][] A = new int[H][W];
        int[][] B = new int[H + X][W + Y];
        for(int i = 0; i < H + X; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < W + Y; j++)
                B[i][j] = Integer.parseInt(temp[j]);
        }

        for(int i = 0; i < X; i++){
            for(int j = 0; j < W; j++)
                A[i][j] = B[i][j];
        }

        int r = H - X, c = 0;
        for(int i = H; i < H + X; i++){
            for(int j = Y; j < W + Y; j++)
                A[r][c++] = B[i][j];
            c = 0;
            r++;
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < Y; j++)
                A[i][j] = B[i][j];
        }

        r = 0; c = W - Y;
        for(int i = X; i < H + X; i++) {
            for (int j = W; j < W + Y; j++)
                A[r][c++] = B[i][j];
            c = W - Y;
            r++;
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(A[i][j] == 0)
                    A[i][j] = B[i][j] - A[i-X][j-Y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++)
                sb.append(A[i][j]).append(" ");
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}

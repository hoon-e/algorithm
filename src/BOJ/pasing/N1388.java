package BOJ.pasing;

import java.io.*;
import java.util.*;

public class N1388 {
    static char[][] board;
    static int cnt;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i=0; i<N; i++)
            board[i] = in.readLine().toCharArray();

        for(int i=0; i<N; i++){
            char prev = 'x';
            for(int j=0; j<M; j++){
                if (board[i][j] == '-' && prev != board[i][j]) {
                    ++cnt;
                }
                prev = board[i][j];
            }
        }

        for(int i=0; i<M; i++){
            char prev = 'x';
            for(int j=0; j<N; j++){
                if (board[j][i] == '|' && prev != board[j][i]) {
                    ++cnt;
                }
                prev = board[j][i];
            }
        }

        out.write(cnt+"\n");
        out.flush();
        out.close();
        in.close();
    }
}

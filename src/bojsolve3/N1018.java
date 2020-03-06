package bojsolve3;

import java.io.*;
import java.util.StringTokenizer;

public class N1018 {
    static char[][] Wgo = {{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
    static char[][] Bgo = {{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] go = new char[M][N];

        for(int i=0; i<M; i++){
            go[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i < M-7; i++){
            for(int j=0; j < N-7; j++){
                min = Math.min(min, check(go,i,j));
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int check(char[][] go, int i, int j){
        int minW = 0;
        int minB = 0;
        for(int a = i; a < i+8; a++){
            for(int b = j; b < j+8; b++){
                if(go[a][b] == Bgo[a-i][b-j]) {
                    minW++;
                }
            }
        }

        for(int a = i; a < i+8; a++){
            for(int b = j; b < j+8; b++){
                if(go[a][b] == Wgo[a-i][b-j]){
                    minB++;
                }
            }
        }

        return Math.min(minW,minB);
    }
}

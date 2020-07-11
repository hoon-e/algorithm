package RE.simulation;

import java.io.*;
import java.util.*;

public class n1018 {
    static int N;
    static int M;
    static char[][] map;
    static char[] word = {'B', 'W'};
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++)
            map[i] = in.readLine().toCharArray();

        int min = 1_000_000;

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                min = min(min, min(findMinCount(i, j, 0), findMinCount(i, j, 1)));
            }
        }

        out.write(min + "");
        out.flush();
        in.close();
        out.close();
    }

    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static int findMinCount(int row, int col, int idx) {
        int cnt = 0;

        for(int i=row; i<row+8; i++){
            for(int j=col; j<col+8; j++){
                // 홀수 행일 경우, idx가 0일 경우 B먼저, 1일 경우 W먼저
                if( i % 2 == 0 ){
                    // 만약 홀수 열인데 b가 아니라면 갯수 증가
                    if( j % 2 == 0 && map[i][j] != word[idx] )
                        ++cnt;
                    else if( j % 2 == 1 && map[i][j] != word[1-idx] )
                        ++cnt;
                }else {
                    if( j % 2 == 0 && map[i][j] != word[1-idx] )
                        ++cnt;
                    else if( j % 2 == 1 && map[i][j] != word[idx] )
                        ++cnt;
                }
            }
        }

        return cnt;
    }
}

package BOJ.DFS_BFS;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class n1325 {
    static int N;
    static int E;
    static ArrayList<Integer>[] computers;
    static boolean[] vst;
    static int cnt;
    static int[] number;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N+1];
        number = new int[N+1];

        for(int i=1; i<=N; i++){
            computers[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[b].add(a);
        }

        int max = -1;

        for(int i=1; i<=N; i++) {
            vst = new boolean[N+1];
            cnt = 0;

            System.out.print(i + " => ");
            dfs(i);
            System.out.println();
            number[i] = cnt;

            max = Math.max(max, cnt);
        }

        for(int i=1; i<=N; i++) {
            if(number[i] == max) {
                out.write(i + " ");
            }
        }

        out.flush();
        in.close();
        out.close();
    }

    static void dfs(int v) {
        vst[v] = true;

        for( int next : computers[v] ){
            if(!vst[next]){
                System.out.print(next + " => ");
                dfs(next);
                ++cnt;
            }
        }
    }
}

package BOJ.graph;

import java.io.*;
import java.util.*;

// Disjoint Set
public class n1976 {
    // 도시의 수
    static int N;
    static int M;
    static int[][] map;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());

        map = new int[N+1][N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++)
            parent[i] = i;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(in.readLine());

            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(in.readLine());

        int flag = 0;
        boolean f = false;

        while(st.hasMoreTokens()){
            if(flag == 0){
                flag = find(Integer.parseInt(st.nextToken()));
            }else {
                int p = Integer.parseInt(st.nextToken());
                int q = find(p);
                if(flag != q){
                    f = false;
                    break;
                }else{
                    f = true;
                    flag = q;
                }
            }
        }

        if(f)
            out.write("YES\n");
        else
            out.write("NO\n");

        out.flush();
        in.close();
        out.close();
    }

    static int find(int val){
        if( val == parent[val] )
            return val;
        else
            return parent[val] = find(parent[val]);
    }

    static void union(int u, int v){
        u = find(u);
        v = find(v);

        if( u != v ){
            parent[v] = u;
        }
    }
}

package BOJ.graph;

import java.io.*;
import java.util.*;

public class n1717 {
    static int[] parent;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i=0; i<=N; i++)
            parent[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(flag == 0){
                union(a, b);
            }else{
                if(findSet(a) == findSet(b))
                    out.write("YES\n");
                else
                    out.write("NO\n");
            }
        }

        out.flush();
        in.close();
        out.close();
    }

    // 집합을 찾는 함수
    public static int findSet(int val){
        // 들어온 값과 부모의 값이 같다면, val을 리턴해준다.
        if(val == parent[val])
            return val;
        else{
            // 아니라면 val의 부모를 다시 찾는다.
            parent[val] = findSet(parent[val]);
            return parent[val];
        }
    }

    // 합집합 함수
    public static void union(int x, int y){
        // x의 부모
        int px = findSet(x);
        // y의 부모
        int py = findSet(y);

        // x의 부모와 y의 부모가 같지않다면
        if(px != py)
            // py의 부모를 px로 설정
            parent[py] = px;
    }
}

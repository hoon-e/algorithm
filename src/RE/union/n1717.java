package RE.union;

import java.io.*;
import java.util.*;

// 집합의 표현
public class n1717 {
    static int n;
    static int m;
    static int[] set;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        set = new int[n+1];

        for(int i=0; i<=n; i++)
            set[i] = i;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(in.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0){
                union(a, b);
            }else {
                if(find(a) == find(b))
                    out.write("YES\n");
                else
                    out.write("NO\n");
            }
        }

        out.flush();
        in.close();
        out.close();
    }

    static int find(int val){
        if(val == set[val])
            return val;
        else
            return set[val] = find(set[val]);
    }

    static void union(int a, int b){
        int px = find(a);
        int py = find(b);

        if(px != py)
            set[py] = px;
    }
}

package RE.dfs;

import java.util.*;
import java.io.*;

public class n6603 {
    static int[] number, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(st.nextToken());
            if( n == 0 ) break;

            number = new int[n];
            ans = new int[6];

            for(int i=0; i<n; i++)
                number[i] = Integer.parseInt(st.nextToken());

            makeCombi(0, 0, n, sb);
            bw.write(sb.toString()+"\n");
        }
        bw.flush();
    }

    private static void makeCombi(int start, int cnt, int n, StringBuilder sb) {
        if(cnt == 6) {
            for(int w : ans)
                sb.append(w).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++) {
            ans[cnt] = number[i];
            makeCombi(i+1, cnt+1, n, sb);
        }
    }
}

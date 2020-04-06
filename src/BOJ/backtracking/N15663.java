package BOJ.backtracking;

import java.io.*;
import java.util.*;

public class N15663 {
    static int n;
    static int m;
    static ArrayList<Integer> a;
    static int[] visit = new int[10001];
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();

        for(int i=0; i<n; i++){
            int w = Integer.parseInt(st.nextToken());
            set.add(w);
            visit[w]++;
        }

        a = new ArrayList<>(set);
        sb = new StringBuffer();
        find("", 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void find(String str, int len){
        if(len == m){
            sb.append(str).append("\n");
            return;
        }

        for (Integer integer : a) {
            if (visit[integer] > 0) {
                visit[integer]--;
                find(str + integer + " ", len + 1);
                visit[integer]++;
            }
        }
    }
}

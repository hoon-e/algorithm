package BOJ.DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;

public class minsu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] printer = new int[n+1];

        int max = Integer.MIN_VALUE;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            for(int j=a; j<=b; j++) {
                printer[j] += w;
                max = Math.max(printer[j], max);
            }
        }

        for(int w : printer)
            System.out.print(w+ " ");

        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

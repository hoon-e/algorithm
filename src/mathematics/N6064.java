package mathematics;

import java.io.*;
import java.util.StringTokenizer;

public class N6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());

        for(int i=0; i<c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(solve(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int m, int n, int x, int y){
        if( x == m ) x = 0;
        if( y == n ) y = 0;
        for(int i=x; i<=m*n; i+=m){
            if(i % n == y) return i;
        }
        return -1;
    }
}

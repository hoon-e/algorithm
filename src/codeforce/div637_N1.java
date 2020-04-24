package codeforce;

import java.io.*;
import java.util.StringTokenizer;

public class div637_N1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        int n, a, b, c, d;
        while(test-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if( (a-b)*n > c+d || (a+b)*n < c-d )
                bw.write("NO\n");
            else
                bw.write("YES\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

package BOJ.bojsolve3;

import java.io.*;
import java.util.StringTokenizer;

public class N7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[][] v = new int[num][2];
        int[] c = new int[num];

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            c[i] = 1;
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if( v[i][0] < v[j][0] && v[i][1] < v[j][1])
                    c[i]++;
            }
            bw.write(c[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

package BOJ.io;

import java.io.*;
import java.util.StringTokenizer;

// 영식 요금제 : 30초마다 10원씩
// 민식 요금제 : 60초마다 15원씩

public class N1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] call = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        int y=0; int m=0;
        while(st.hasMoreTokens()){
            call[i] = Integer.parseInt(st.nextToken());
            y += ((call[i]/30)+1)*10;
            m += ((call[i]/60)+1)*15;
        }

        if( y > m )
            bw.write("M " + m);
        else if( y == m )
            bw.write("Y M " + y);
        else
            bw.write("Y " + y);

        bw.flush();
        bw.close();
        br.close();
    }
}

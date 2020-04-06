package BOJ.recur;

import java.io.*;
import java.util.StringTokenizer;

public class N1629 {
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A %= C;

        bw.write(divide(B)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static long divide(int count){
        // 10^11 = (10^2)^5 * 10
        // 10^10 = (10^2)^5
        if(count == 0)
            return 1;
        else if(count % 2 == 1)
            return (divide(count-1) * A) % C;
        else{
            long temp = divide(count/2) % C;
            return temp * temp % C;
        }
    }
}

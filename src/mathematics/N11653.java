package mathematics;

import java.io.*;

public class N11653 {
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        factor(n);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void factor(int n){
        for(int i = 2; i*i <= n; i++){
            while(n%i == 0){
                sb.append(i).append("\n");
                n /= i;
            }
        }
        if(n != 1)
            sb.append(n);
    }
}

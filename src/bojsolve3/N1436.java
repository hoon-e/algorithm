package bojsolve3;

import java.io.*;

public class N1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int n=0;

        while( count != num ){
            if(String.valueOf(++n).contains("666")){
                count++;
            }
        }
        bw.write(n+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

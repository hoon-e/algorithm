package bojsolve3;

import java.io.*;

public class N2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i=num-1; i>=0; i--){
            for(int j=i; j>0; j--){
                bw.write(" ");
            }
            for(int k=2*num-2*i-1; k>0; k--){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

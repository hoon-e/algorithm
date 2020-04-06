package BOJ.bojsolve3;

import java.io.*;

public class N5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] burger = new int[3];
        int[] cola = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            burger[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<2; i++){
            cola[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                int set = burger[i] + cola[j] - 50;
                min = Math.min(min, set);
            }
        }
        bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

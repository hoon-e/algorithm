package greedy;

import java.io.*;

public class N10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] t = {300, 60, 10};
        int[] result = new int[3];
        int time = Integer.parseInt(br.readLine());

        if(time % 10 != 0){
            bw.write(-1+"\n");
            bw.flush();
            return;
        }else{
            result[0] = time / t[0];
            time -= (result[0]*t[0]);
            result[1] = (time) / t[1];
            time -= (result[1]*t[1]);
            result[2] = time / t[2];
        }

        for(int s : result)
            bw.write(s+ " ");
        bw.flush();
        bw.close();
        br.close();
    }
}

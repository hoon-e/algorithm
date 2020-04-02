package greedy;

import java.io.*;

public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("-");
        int ret = 0;

        for(int i=0; i<input.length; i++){
            int ans = add(input[i]);
            if(i == 0) ret += ans;
            else ret -= ans;
        }

        bw.write(ret+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int add(String val){
        String[] op = val.split("\\+");
        int sum = 0;

        for(String num : op)
            sum += Integer.parseInt(num);
        return sum;
    }
}

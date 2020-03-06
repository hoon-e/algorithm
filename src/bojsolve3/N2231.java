package bojsolve3;

import java.io.*;

public class N2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int con = Integer.MAX_VALUE;

        for(int i=1; i<=num; i++){
            String n = Integer.toString(i);
            int sum;

            if( n.length() == 1){
                continue;
            }
            else{
                sum = i;
                for(int j=0; j<n.length(); j++){
                    sum += (n.charAt(j)-'0');
                }
            }

            if( sum == num ){
                if( i < con ){
                    con = i;
                }
            }
        }

        if( con == Integer.MAX_VALUE ){
            bw.write(0+"\n");
        }else{
            bw.write(con+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

package BOJ.greedy;

import java.io.*;

public class N5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int yen = Integer.parseInt(br.readLine());

        int change = 1000 - yen;
        int[] money = {500, 100, 50, 10, 5, 1};

        int count = 0;

        while(change > 0){
            if(change >= money[0]){
                int sub = change / money[0];
                change -= sub*money[0];
                count += sub;
            }else if(change >= money[1]){
                int sub = change / money[1];
                change -= sub*money[1];
                count += sub;
            }else if(change >= money[2]){
                int sub = change / money[2];
                change -= sub*money[2];
                count += sub;
            }else if(change >= money[3]){
                int sub = change / money[3];
                change -= sub*money[3];
                count += sub;
            }else if(change >= money[4]){
                int sub = change / money[4];
                change -= sub*money[4];
                count += sub;
            }else {
                int sub = change / money[5];
                change -= sub * money[5];
                count += sub;
            }
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

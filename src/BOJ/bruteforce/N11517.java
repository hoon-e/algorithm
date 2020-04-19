package BOJ.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class N11517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num = new int[4];

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;

            for(int i=0; i<4; i++){
                num[i] = Integer.parseInt(st.nextToken());

                if(num[i] == -1)
                    idx = i;
            }

            if(num[0] == -1 && num[1] == -1 && num[2] == -1 && num[3] == -1) break;
            bw.write(findNum(num, idx)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int findNum(int[] num, int idx){
        switch(idx){
            case 0:
                if(num[3]-num[2] == num[2]-num[1]) {
                    if( num[2]-2*num[1] > 0 ) return num[2]-2*num[1];
                }
                if((num[3] % num[2] == 0 && num[2] % num[1] == 0)){
                    if( num[2] / (num[3]/num[2]) > 0 ) return num[2] / (num[3] / num[2]);
                }
                break;
            case 1:
                if(num[3] % num[0] == 0 && num[3] % num[2] == 0 && ((num[3]/num[2] == (int)Math.sqrt(num[2]/num[0])))) {
                    return num[0] * (num[3]/num[2]);
                }
                if(((num[2] - num[0]) % 2 == 0) && (((num[2] - num[0])/ 2) == num[3]-num[2])){
                    if(2*num[2] - num[3] > 0) return 2*num[2] - num[3];
                }
                break;
            case 2:
                if(num[1] % num[0] == 0 && num[3] % num[1] == 0 && ((num[1]/num[0] == (int)Math.sqrt(num[3]/num[1])))) {
                    if(num[1] * (num[1]/num[0]) > 0) return num[1] * (num[1]/num[0]);
                }
                if(num[1] - num[0] == (num[3] - num[1])/2){
                    if(num[1] + (num[1]-num[0]) > 0) return num[1] + (num[1]-num[0]);
                }
                break;
            case 3:
                if((num[2] % num[1] == 0 && num[1] % num[0] == 0) && ((num[2] / num[1]) == (num[1] / num[0]))) {
                    if(num[2] * (num[1] / num[0]) > 0) return num[2] * (num[1] / num[0]);
                }
                if(num[1] - num[0] == num[2] - num[1]){
                    if(num[2] + (num[2] - num[1]) > 0) return num[2] + (num[2] - num[1]);
                }
        }
        return -1;
    }
}

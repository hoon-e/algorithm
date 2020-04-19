package BOJ.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class N9094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(findCase(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))+"\n");
        }

        bw.flush();
        bw.close();
    }

    static int findCase(int a, int b){
        int cnt = 0;
        int temp = 0;

        for(int i=1; i<a; i++){
            temp += (int)Math.pow(i,2);
            for(int j=i+1; j<a; j++){
                temp += ((int)Math.pow(j,2)+b);

                if(temp % (i*j) == 0)
                    cnt++;

                temp -= ((int)Math.pow(j,2)+b);
            }
            temp -= (int)Math.pow(i,2);
        }
        return cnt;
    }
}

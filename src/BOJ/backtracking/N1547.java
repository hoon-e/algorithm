package BOJ.backtracking;

import java.io.*;
import java.util.StringTokenizer;

//
public class N1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        boolean[] ball = new boolean[4];
        ball[1] = true;
        int isBall = 1;

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if( x == y )
                continue;

            if(y == isBall && x != isBall ){
                ball[isBall] = false;
                isBall = x;
                ball[isBall] = true;
            }else if(x == isBall && y != isBall){
                ball[isBall] = false;
                isBall = y;
                ball[isBall] = true;
            }
        }
        
        bw.write(isBall+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

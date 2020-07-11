package RE.simulation;

import java.io.*;
import java.util.*;

public class n2455 {
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int max = -1;
        int man = 0;
        for(int i=0; i<4; i++){
            st = new StringTokenizer(in.readLine());
            int sub = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());

            man -= sub;
            man += plus;

            max = max(max, man);
        }
        out.write(max+"");
        out.flush();
        in.close();
        out.close();
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }
}

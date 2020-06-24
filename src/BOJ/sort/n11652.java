package BOJ.sort;

import java.io.*;
import java.util.*;

public class n11652 {
    static int N;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Long, Integer> card = new HashMap<>();

        N = Integer.parseInt(in.readLine());
        int max = 0;
        long idx = Long.MAX_VALUE;

        for(int i=0; i<N; i++){
            long v = Long.parseLong(in.readLine());

            // 정수 값이 없다면, 갯수 1로 하여 추가
            if(card.get(v) == null){
                card.put(v, 1);
            }else {
                int val = card.get(v);
                card.put(v, val + 1);
            }

            int val = card.get(v);

            if( val == max ){
                if( idx > v ) {
                    idx = v;
                }
            }

            if( val > max ){
                max = val;
                idx = v;
            }
        }

        out.write(idx + "\n");
        out.flush();
        in.close();
        out.close();
    }
}

package RE.simulation;

import java.io.*;
import java.util.*;

public class n1966 {
    static class doc {
        int num;
        int prior;

        doc(int num, int prior){
            this.num = num;
            this.prior = prior;
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(in.readLine());

        for(int i=0; i<tc; i++){
            st = new StringTokenizer(in.readLine());

            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            Queue<doc> docs = new LinkedList<>();

            // 숫자 입력
            st = new StringTokenizer(in.readLine());

            for(int j=0; j<N; j++)
                docs.offer(new doc(j, Integer.parseInt(st.nextToken())));

            int num = 1;
            boolean isUp;

            while(true){
                doc cur = docs.poll();
                isUp = false;

                for(doc d : docs){
                    if(d.prior > cur.prior) {
                        isUp = true;
                        break;
                    }
                }

                if(!isUp && cur.num == idx) break;

                if(isUp) docs.offer(cur);
                else ++num;
            }

            out.write(num+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}

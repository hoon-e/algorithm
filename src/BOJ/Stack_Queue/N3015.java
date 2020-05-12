package BOJ.Stack_Queue;

import java.io.*;
import java.util.*;

class oasis {
    long height;
    long man;

    oasis(long height, long man){
        this.height = height;
        this.man = man;
    }
}

public class N3015 {
    static long pair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<oasis> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            long temp = Long.parseLong(br.readLine());
            oasis cur = new oasis(temp, 1);

            while(!s.isEmpty()){
                if(s.peek().height <= cur.height){
                    pair += s.peek().man;

                    if(s.peek().height == cur.height){
                        cur.man += s.peek().man;
                    }
                    s.pop();
                }else
                    break;
            }

            if(!s.isEmpty())
                ++pair;

            s.push(cur);
        }

        bw.write(pair+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

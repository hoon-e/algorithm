package BOJ.bojsolve3;

import java.io.*;
import java.util.Stack;

public class N1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> b = new Stack<>();
        b.push(64);

        int X = Integer.parseInt(br.readLine());
        int sum = 64;

        if(X == 64){
            bw.write(1+"");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        while(true){
            if( sum > X ){
                sum = 0;
                int half = b.pop()/2;

                b.add(half);

                for(int s : b)
                    sum += s;

                if(sum < X){
                    b.add(half);
                    sum += half;
                }
            }else
                break;
        }

        bw.write(b.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
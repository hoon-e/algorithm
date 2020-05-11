package BOJ.Stack_Queue;

import java.io.*;
import java.util.Stack;

public class N1725 {
    static long[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long max = 0;
        int test = Integer.parseInt(br.readLine());
        Stack<Integer> hist = new Stack<>();

        height = new long[test+1];

        for(int i=0; i<test; i++){
            height[i] = Long.parseLong(br.readLine());
        }

        for(int i=0; i<test; i++){
            while(!hist.isEmpty() && height[i] < height[hist.peek()]){
                long h = height[hist.pop()];
                long width = i;

                if(!hist.isEmpty()){
                    width = i-hist.peek()-1;
                }

                max = Math.max(max, width*h);
            }
            hist.push(i);
        }

        while(!hist.isEmpty()){
            long h = height[hist.pop()];
            long width = test;

            if(!hist.isEmpty()){
                width = test-hist.peek()-1;
            }
            max = Math.max(max, width * h);
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
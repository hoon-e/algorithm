package BOJ.bojsolve3;

import java.io.*;

public class N10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        bw.write(fib(num)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int fib(int num){
        if(num == 0)
            return 0;
        else if(num == 1)
            return 1;
        else
            return fib(num-2)+fib(num-1);
    }
}

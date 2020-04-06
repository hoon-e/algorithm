package BOJ.bojsolve3;

import java.io.*;

public class N10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        bw.write(fib(num)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int fib(int a){
        if( a == 0 )
            return 1;
        else
            return a*fib(a-1);
    }
}

package bojsolve3;

import java.io.*;

public class N11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int num=Integer.parseInt(br.readLine());
        bw.write(((1<<num)-1)+"\n");
        hanoi(1, 3, num, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    static void hanoi(int a, int b, int n, BufferedWriter bw) throws IOException {
        if(n==1){
            bw.write(a + " " + b + "\n");
            return;
        }
        int c = 6-a-b;
        hanoi(a,c,n-1,bw);
        bw.write(a + " " + b + "\n");
        hanoi(c,b,n-1, bw);
    }
}
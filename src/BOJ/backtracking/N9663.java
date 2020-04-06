package BOJ.backtracking;

import java.io.*;

public class N9663 {
    static boolean[] issued1 = new boolean[40];
    static boolean[] issued2 = new boolean[40];
    static boolean[] issued3 = new boolean[40];
    static int count;
    static int n;

    static void queen(int current){
        if(current == n){
            count++;
            return;
        }
        for(int i=0; i<n; i++){ // (current, i)에 말이 놓아진다.
            if(issued1[i] || issued2[i+current] || issued3[current - i + n-1])
                continue;
            issued1[i] = true;
            issued2[i+current] = true;
            issued3[current-i+n-1] = true;
            queen(current+1);
            issued1[i] = false;
            issued2[i+current] = false;
            issued3[current-i+n-1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        queen(0);

        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

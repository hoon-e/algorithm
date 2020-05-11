package BOJ.Stack_Queue;

import java.io.*;
import java.util.Stack;

public class N3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0; i<test; i++){
            char[] line = br.readLine().toCharArray();
            cnt += check(line);
        }
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int check(char[] line){
        Stack<Character> s = new Stack<>();

        for (char c : line) {
            if (s.isEmpty())
                s.push(c);
            else {
                if (s.peek() == c) {
                    s.pop();
                } else
                    s.push(c);
            }
        }

        if(!s.isEmpty())
            return 0;
        else
            return 1;
    }
}

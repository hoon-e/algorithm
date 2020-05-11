package BOJ.Stack_Queue;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Stack;

public class N1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        Stack<Double> exp = new Stack<>();

        char[] line = br.readLine().toCharArray();

        for(int i=0; i<number; i++){
            alpha[i] = Integer.parseInt(br.readLine());
        }

        for(char w : line){
            if(Character.isAlphabetic(w)){
                exp.push((double)alpha[w-'A']);
            }else{
                double f, s;
                switch(w){
                    case '+':
                        f = exp.pop();
                        s = exp.pop();
                        exp.push((double)(s+f));
                        break;
                    case '-':
                        f = exp.pop();
                        s = exp.pop();
                        exp.push((double)(s-f));
                        break;
                    case '*':
                        f = exp.pop();
                        s = exp.pop();
                        exp.push((double)(s*f));
                        break;
                    case '/':
                        f = exp.pop();
                        s = exp.pop();
                        exp.push((double)(s/f));
                        break;
                }
            }
        }

        String ans = String.format("%.2f", exp.pop());

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

package about_arr;

import java.io.*;
import java.util.Stack;

public class N1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        String line = br.readLine();

        for(int i=0; i<line.length(); i++)
            s1.add(line.charAt(i));

        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            String op = br.readLine();

            if(op.equals("L")){
                if(s1.isEmpty())
                    continue;
                s2.add(s1.pop());
            }else if(op.equals("D")){
                if(s2.isEmpty())
                    continue;
                s1.add(s2.pop());
            }else if(op.equals("B")){
                if(s1.isEmpty())
                    continue;
                s1.pop();
            }else if(op.charAt(0) == 'P'){
                String[] o = op.split(" ");
                s1.add(o[1].toCharArray()[0]);
            }
        }

        while(!s2.isEmpty())
            s1.add(s2.pop());

        for(char w : s1)
            bw.write(w);
        bw.flush();
        bw.close();
        br.close();
    }
}
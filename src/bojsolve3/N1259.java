package bojsolve3;

import java.io.*;

public class N1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb;
        int left_index;
        int right_index;
        String left;
        String right;

        while(true){
            String num = br.readLine();
            if(num.equals("0"))
                break;
            int len = num.length();

            if(len == 1){
                bw.write("yes\n");
                continue;
            }
            if(len%2 == 0) {
                left_index = len/2;
                right_index = len/2;
            }else {
                left_index = len/2;
                right_index = len/2+1;
            }
            sb = new StringBuffer();
            left = num.substring(0, left_index);
            right = num.substring(right_index, len);

            for(int i=right.length()-1; i>=0; i--)
                sb.append(right.charAt(i));

            if(Integer.parseInt(left) == Integer.parseInt(sb.toString()))
                bw.write("yes\n");
            else
                bw.write("no\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

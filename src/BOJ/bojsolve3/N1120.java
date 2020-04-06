package BOJ.bojsolve3;

import java.io.*;

public class N1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int count=Integer.MAX_VALUE;

        for(int i=0; i<line[1].length()-line[0].length()+1; i++){
            int m = 0;
            for(int j=0; j<line[0].length(); j++){
                if(line[0].charAt(j) != line[1].charAt(j+i))
                    m++;
            }
            count = Math.min(m, count);
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

package mathematics;

import java.io.*;

public class N1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        bw.write(((num/5)+(num/25)+(num/125))+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

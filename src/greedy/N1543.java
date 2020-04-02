package greedy;

import java.io.*;

public class N1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = br.readLine();
        String src = br.readLine();

        int count = Integer.MIN_VALUE;

        if(doc.length() < src.length()) {
            count = 0;
        }
        else {
            for (int i = 0; i < doc.length(); i++) {
                if (doc.charAt(i) != src.charAt(0)) continue;
                if (i + src.length() > doc.length()) continue;

                int j = i;
                int temp = 0;
                while (j + src.length() <= doc.length()) {
                    String t = doc.substring(j, j + src.length());
                    if (t.charAt(0) != src.charAt(0)) {
                        j++;
                        continue;
                    }
                    if (t.equals(src)) {
                        j += src.length();
                        temp++;
                    } else
                        j++;
                }
                count = Math.max(count, temp);
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

package RE.string;

import java.io.*;

public class n2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String l = br.readLine();

        int cnt = 0;
        for(int i=0; i<l.length(); i++) {
            char w = l.charAt(i);
            char next = (i+1 < l.length()) ? l.charAt(i+1) : ' ';

            if(w == 'l') {
                if(next == 'j') ++i;
                ++cnt;
            } else if(w == 'c') {
                if(next == '=') ++i;
                else if(next == '-') ++i;
                ++cnt;
            } else if(w == 'd') {
                if(next == '-') ++i;
                else if(next == 'z' && i + 2 < l.length() && l.charAt(i+2) == '=') i += 2;
                ++cnt;
            } else if(w == 'n') {
                if(next == 'j') ++i;
                ++cnt;
            } else if(w == 's') {
                if(next == '=') ++i;
                ++cnt;
            } else if(w == 'z') {
                if(next == '=') ++i;
                ++cnt;
            } else
                ++cnt;
        }

        bw.write(cnt + "");
        bw.flush();
    }
}

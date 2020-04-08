package BOJ.hash;

import java.io.*;
import java.util.*;

public class N7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        Set<String> com = new HashSet<>();

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String operation = st.nextToken();

            if(operation.equals("enter"))
                com.add(name);
            else
                com.remove(name);
        }

        List<String> o = new ArrayList(com);
        o.sort(Comparator.reverseOrder());

        for(String s : o)
            bw.write(s+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

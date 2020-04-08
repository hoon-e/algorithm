package BOJ.hash;

import java.io.*;
import java.util.*;

public class N1764 {
    static String[] db;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N ,M;

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<String> dbj = new ArrayList<>();
        ArrayList<String> d = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0; i<N; i++) {
            String word = br.readLine();
            d.add(word);
        }
        Collections.sort(d);

        db = new String[d.size()];
        db = d.toArray(db);

        for(int i=0; i<M; i++){
            String line = br.readLine();

            if(binarySearch(line, N) >= 0) {
                count++;
                dbj.add(line);
            }
        }
        Collections.sort(dbj);

        bw.write(count+"\n");
        for(String s : dbj)
            bw.write(s+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(String target, int len){
        int start = 0;
        int end = len-1;

        while(start <= end){
            int mid = (start+end)/2;

            if(db[mid].compareTo(target) < 0)
                start = mid+1;
            else if(db[mid].compareTo(target) > 0)
                end = mid-1;
            else
                return mid;
        }
        return -(start+1);
    }
}

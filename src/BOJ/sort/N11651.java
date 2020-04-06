package BOJ.sort;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Point> p = new ArrayList<>();

        while(num-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Comparator<Point> pSort = ( (p1, p2) -> {
            if( p1.y == p2.y )
                return p1.x - p2.x;
            else
                return p1.y - p2.y;
        });

        p.sort(pSort);

        for(Point s : p){
            bw.write(s.x + " " + s.y + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

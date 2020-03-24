package greedy;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N2457 {

    static class Flower {
        int smonth;
        int sday;
        int fmonth;
        int fday;

        Flower(int smonth, int sday, int fmonth, int fday){
            this.smonth = smonth;
            this.sday = sday;
            this.fmonth = fmonth;
            this.fday = fday;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int flower = Integer.parseInt(br.readLine());
        LinkedList<Flower> cal = new LinkedList<>();

        for(int i=0; i<flower; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cal.add(new Flower(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Comparator<Flower> flowerComparator = (f1, f2) -> {
            if( f1.fmonth == f2.fmonth ){
                return f2.fday - f1.fday;
            }else if(f1.fmonth < f2.fmonth) {
                return f2.fmonth - f1.fmonth;
            }
            else{
                if( f1.smonth == f2.smonth )
                    return f1.sday - f2.sday;
                else
                    return f1.smonth - f2.smonth;
            }
        };

        cal.sort(flowerComparator);

        for(Flower fo : cal){
            System.out.println(fo.smonth + " " + fo.sday + " " + fo.fmonth + " " + fo.fday);
        }

        int f = 0;
        int now = 0;

        for(Flower fo : cal){
            if( now > fo.smonth ) continue;
            f++;
            now = fo.fmonth;
        }

        bw.write(f+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

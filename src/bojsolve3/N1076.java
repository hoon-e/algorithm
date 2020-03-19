package bojsolve3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class N1076 {
    static class ohm{
        int value;
        long mul;

        ohm(int value, long mul){
            this.value = value;
            this.mul = mul;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long ohmvalue = 0;
        Map<String, ohm> o = new HashMap<>();
        o.put("black", new ohm(0, 1));
        o.put("brown", new ohm(1, 10));
        o.put("red", new ohm(2, 100));
        o.put("orange", new ohm(3, 1000));
        o.put("yellow", new ohm(4, 10000));
        o.put("green", new ohm(5, 100000));
        o.put("blue", new ohm(6, 1000000));
        o.put("violet", new ohm(7, 10000000));
        o.put("grey", new ohm(8, 100000000));
        o.put("white", new ohm(9, 1000000000));

        for(int i=0; i<2; i++){
            String color = br.readLine();
            sb.append(o.get(color).value);
        }
        String color = br.readLine();
        ohmvalue = Integer.parseInt(sb.toString())*o.get(color).mul;
        bw.write(ohmvalue+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

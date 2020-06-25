package BOJ.sort;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class n1041 {
    static int N;
    static int[] dice = new int[6];
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        ArrayList<Integer> minIndex = new ArrayList<>();

        int minVal = 0;
        for(int i=0; i<6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());

            if( i == 0 ) {
                minVal = dice[i];
            }else {
                if( dice[i] < minVal ){
                    minIndex.clear();
                    minIndex.add(i);
                }else if( dice[i] == minVal ){
                    minIndex.add(i);
                }
            }
        }

        int[] arr = null;

        if(minIndex.size() > 1){
            arr = find(minIndex.get(0));
            for(int i=1; i < minIndex.size(); i++){
                int[] newArr = find(minIndex.get(i));

                if(newArr[1] < arr[1]){
                    arr = newArr;
                }
            }
        }else {
            arr = find(minIndex.get(0));
        }

        long sum = 0;
        if(N == 1){
            Arrays.sort(dice);

            for(int i=4; i>=0; i--)
                sum += dice[i];
        }else {
            sum += ( arr[0] * (pow(N-2) + 4 *(pow(N) - 3*N + 2)) );
            sum += ( 4 * (2*N - 3) * arr[1] );
            sum += ( 4 * arr[2] );
        }

        out.write(sum+"");
        out.flush();
        in.close();
        out.close();
    }

    static int[] find(int idx){
        ArrayList<Integer> newNum = new ArrayList<>();
        int[] sum = new int[3];

        for(int i=0; i<6; i++){
            if(i == 5-idx) continue;
            newNum.add(dice[i]);
        }

        Collections.sort(newNum);

        for(int a : newNum)
            System.out.print(a + " ");
        System.out.println();
        System.out.println("=====");

        sum[0] = newNum.get(0);
        sum[1] = sum[0] + newNum.get(1);
        sum[2] = sum[1] + newNum.get(2);

        for(int i=0; i<3; i++)
            System.out.print(sum[i] + " ");
        System.out.println();

        return sum;
    }

    static long pow(int a){
        return (a * a);
    }
}

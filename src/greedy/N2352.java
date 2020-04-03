package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class N2352 {
    static int[] port;
    static int[] input;
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        input = new int[num];
        port = new int[num];

        for(int i=0; i<num; i++){
            input[i] = scn.nextInt();
        }

        port[0] = input[0];
        int size = 1;

        for(int index=1; index<num; index++){
            if(port[0] > input[index])
                port[0] = input[index];
            else if(port[size-1] < input[index]){
                port[size] = input[index];
                size++;
            }else{
                int idx = Arrays.binarySearch(port, 0, size, input[index]);
                if( idx < 0 ) idx = -1-idx;
                port[idx] = input[index];
            }
        }
        System.out.println(size);
        scn.close();
    }
}

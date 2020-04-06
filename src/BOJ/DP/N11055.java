package BOJ.DP;

import java.io.*;
import java.util.Scanner;

public class N11055 {
    static int[] number = new int[1001];
    static int[] sum = new int[1001];
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        long max = 0;

        for(int i=0; i<num; i++)
            number[i] = scn.nextInt();

        sum[0] = number[0];
        for(int j=1; j<num; j++){
            sum[j] = number[j]; // 초기값 설정이 중요하다.
            for(int k=0; k<j; k++){
                if(number[k] < number[j] && sum[j] < sum[k] + number[j]){
                    sum[j] = sum[k] + number[j];
                }
            }
        }

        for(int j=0; j<num; j++){
            if(max < sum[j]) {
                max = sum[j];
            }
        }

        System.out.println(max);
    }
}

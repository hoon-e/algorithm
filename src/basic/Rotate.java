package basic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 길이 N의 배열을 K만큼 회전시키는 함수
// Arrays.copyOf()와 System.arraycopy() 의 차이
// 전자는 복사 후 새로운 배열을 만든다. 후자는 원래 있는 배열에 복사한다.
public class Rotate {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        int N = scn.nextInt();
        int K = scn.nextInt();

        int[] num = new int[N];

        for(int i=0; i<N; i++)
            num[i] = rnd.nextInt(10);

        for(int s : num )
            System.out.print(s + " ");
        System.out.println();
        System.out.println("rotate 1");
        rotate(num, K);
        System.out.println();
        System.out.println("rotate 2");
        rotate_bubble(num, K);
    }

    // #1 - arraycopy
    // O(n) space, O(n) time
    public static void rotate(int[] num, int k){
        if(k > num.length) // k가 num의 길이보다 클 경우
            k = k%num.length;
        int[] result = new int[num.length];

        for(int i=0; i<k; i++)
            result[i] = num[num.length-k+i];

        int j=0;
        for(int i=k; i<num.length; i++){
            result[i] = num[j];
            j++;
        }
//      System.arraycopy(result, 0, num, 0, num.length);

        for(int s : result)
            System.out.print(s + " ");
    }

    // #2 - bubble rotate
    // O(1) space, O(n*k) time
    public static void rotate_bubble(int[] num, int order){
        if(num == null || order < 0)
            throw new IllegalArgumentException("Illegal Argument!");
        int[] result = Arrays.copyOf(num, num.length);

        for(int i=0; i<order; i++){
            for(int j=result.length-1; j>0; j--){
                int temp = result[j];
                result[j] = result[j-1];
                result[j-1] = temp;
            }
        }

        for(int s : result)
            System.out.print(s + " ");
    }
}

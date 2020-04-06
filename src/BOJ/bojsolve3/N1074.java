package BOJ.bojsolve3;

import java.io.*;
import java.util.Scanner;


// 재귀를 이용한 풀이
class Z{
    int n;
    int w;
    int targetX, targetY;
    int count = -1;
    boolean flag = false;

    Z (int n, int x, int y){
        this.n = n;
        this.w = (1<<n);
        targetX = x;
        targetY = y;
    }

    // width가 1일때에만 출력한다.
    void visit(int x, int y ,int width){
        if(width == 1){
            count++;
            if(x==targetX && y==targetY){
                System.out.println(count);
                flag=true;
            }
            return;
        }
        if(flag) return;
        visit(x,y,width/2);
        visit(x, y+width/2, width/2);
        visit(x+width/2, y, width/2);
        visit(x+width/2, y+width/2, width/2);
    }
}

public class N1074 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        Z z = new Z(scn.nextInt(), scn.nextInt(), scn.nextInt());
        z.visit(0, 0, z.w);
    }
}
    /*
    static int visit(int N, int r, int c){
        if( r%2==0 && c%2== 0){
            if(r == 0 && c==0){ return ++count;}
            else if(c-1 < 0){visit(N, r-1, (1<<N)-1);}
            else{visit(N, r+1, c-1);}
        }else if( r%2==0 && c%2==1){
            visit(N, r, c-1);
        }else if( r%2==1 && c%2== 0){
            visit(N, r-1, c+1);
        }else if( r%2==1 && c%2==1){
            visit(N, r, c-1);
        }
        return ++count;
    }
    */

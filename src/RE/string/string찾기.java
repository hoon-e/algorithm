package RE.string;

public class string찾기 {
	/*
	   1 << n  :  2^n의 값을 가짐(원소가 n개일 경우의 모든 부분집합의 수를 의미)

          (i << n) - 1  :   n개의 1 만들기(1오른쪽에 0이 n개 -> -1을 하면 1이 n개 나옴)

          i & ( 1 << index )  :  i의 오른쪽에서 index번째 비트가 1인지 아닌지 확인
                                       :  index자리에 1이 있다면 0이 아닌 수가 나옴 

           i | ( 1 << index )  :  오른쪽에서 index번째 비트를 1로 만들기 (1과 OR연산을 하면 반드시 1이 나옴)
                                     :  index가 0일때, 맨 오른쪽 비트를 가리킴
         
           i & ~( 1 << index )  :  오른쪽에서 index번째 비트를 0으로 만들기

           i &= 0,  i--  :  0에서 1을 빼면 모든 비트가 1이 됨(이진수 특성)

           i ^ ( 1 << index )  :  오른쪽에서 index번째 비트를 전환 (켜져있으면 끄고, 꺼져있으면 켬)

           i & -i  :  첫 번째 비트 찾기 (컴퓨터가 음수 표현을 위해 2의 보수를 사용하는 점을 이용)

           i & ~1  :  오른쪽 맨 끝 비트 0으로 만들기

           i & ( ( 1 << index ) - 1 )  :   index 왼쪽 원소 모두 0으로 바꾸기

           i & ( -1 << index )  :  index 오른쪽 원소 모두 0으로 바꾸기

          Integer.bitCount(i)  :  비트가 1인 것의 개수
	 */
	
	public static void main(String[] args) {
		
	}
}

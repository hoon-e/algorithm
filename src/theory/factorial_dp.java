package theory;

public class factorial_dp {
	/* F(n) := { 0 ( n=0 )
	 * 		   { 1 ( n=1 )
	 *         { Fn-1 + Fn-2 ( n>1 ) */
	public static void main(String[] args) {
		System.out.println(fib_recur(10));
		System.out.println(fibonacci(10));
	}
	
	// DP를 이용해서 피보나치를 푸는 방법 : O(n)
	static int fibonacci(int data) {
		int[] cache = new int[data+1];
		cache[0] = 0;
		cache[1] = 1;
		
		for(int index=2; index<data+1; index++) {
			cache[index] = cache[index-1] + cache[index-2];
		}
		return cache[data];
	}
	
	// 재귀를 이용해서 피보나치를 푸는 방법 : 재귀를 사용하므로 스택을 사용하기 떄문에 O(n)보다는 느리다.
	static int fib_recur(int data) {
		if(data<=1)
			return data;
		else
			return fib_recur(data-1) + fib_recur(data-2);
	}
}

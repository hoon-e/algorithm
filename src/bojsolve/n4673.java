package bojsolve;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 셀프 넘버
public class n4673 {
	public static void main(String[] args) throws IOException {
		boolean[] selfNum = new boolean[100001];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1; i<=10000; i++) {
			int dn = getDn(i);
			if(dn <= 10000) {
				selfNum[dn] = true;
			}
		}

		for(int i=1; i<=10000; i++) {
			if(!selfNum[i]) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

	private static int getDn(int n) {
		int dn = n;
		while(n > 0) {
			dn += n % 10;
			n /= 10;
		}
		return dn;
	}
}

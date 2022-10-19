package ps0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_11726_2xN타일링1_S3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int dp[] = new int[num];
		for (int i = 0; i < num; i++) {
			if(i==0) {
				dp[i] = 1;
			}else if(i==1) {
				dp[i] = 2;
			}else {
				dp[i] = (dp[i-2]+dp[i-1])%10007;
			}
		}
		System.out.println(dp[num-1]);
	}
}

/* 0
 * 1
 * 2...
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];  //1~3으로 끝나는 식
		
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int j=4; j<100001; j++) {
			dp[j][1] = (dp[j-1][2] + dp[j-1][3]) % 1000000009;
			dp[j][2] = (dp[j-2][1] + dp[j-2][3]) % 1000000009;
			dp[j][3] = (dp[j-3][1] + dp[j-3][2]) % 1000000009;
		}
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());  //0<n<=100000
			sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}

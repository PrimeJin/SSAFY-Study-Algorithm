import java.io.*;
import java.util.*;

public class Main_BJ_15486_퇴사2_siha {
	
	static int[] T, P;
	static int N;
	static int max;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N+2];
		P = new int[N+2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//-----------------입력
		
		
		dp = new int[N+2];
		
		for(int i=1;i<N+2;i++) {
			
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int day = i + T[i];
			if(day < N+2) {
				dp[day] = Math.max(dp[day],  max + P[i]);
			}
		
		}
		
		
		System.out.println(max);
		
		
		
	}//main
	
}//end class

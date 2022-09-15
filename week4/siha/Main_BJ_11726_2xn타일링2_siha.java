import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11726_2xn타일링2_siha {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		
		if(N==1 || N==2) {
			if(N==1) System.out.println(1);
			else	System.out.println(3);
			
			System.exit(0);
		}
		
		
		dp[1] = 1;
		dp[2] = 3;
		
		
		for(int i=3;i<N+1;i++) {
			
			dp[i] = (dp[i-1] + (dp[i-2]*2)) % 10007;
			
		}
				
				
		System.out.println(dp[N]);
		
	}
	
}

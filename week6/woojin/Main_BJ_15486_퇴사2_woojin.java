import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] t = new int[N+2];  //상담 걸리는 기간
		int[] p = new int[N+2];  //상담하고 받는 돈
		int[] dp = new int[N+2];  //상담 마지막날에도 1일짜리면 상담할 수 있음
		//1인덱스부터 시작 +1, 마지막날 포함 가능 +1
        //dp 배열 -> 해당 날짜까지 받을 수 있는 최대 금액 저장
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());

			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=1; i<=N+1; i++) {
			max = Math.max(max, dp[i]);  //현재날짜의 dp배열 값과 max중 큰 값으로 갱신
			
			if(i+t[i] <= N+1) {
				dp[i+t[i]] = Math.max(dp[i+t[i]], max+p[i]);  //dp배열엔 현재 날짜에 가질 수 있는 최대값 저장
            }
            
		}
		System.out.println(dp[N+1]);
	}
}

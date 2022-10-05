import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 퇴사
 */

public class Main_BOJ_15486_퇴사2_G5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<int[]>> schedule = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			schedule.add(new ArrayList<>());
		}
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = i; //해당 상담 시작일
			int end = i + Integer.parseInt(st.nextToken())-1; //해당 상담 끝나는 날
			int pay = Integer.parseInt(st.nextToken());
			
			if(end <= N) { //끝나는 날이 N 이전이라면(유효한 상담이라면) 추가
				schedule.get(end).add(new int[]{start, pay});
			}
			
		}

		//dp
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int max = dp[i-1];
			ArrayList<int[]> todayEnds = schedule.get(i);
			for (int[] counsel : todayEnds) {
				max = Math.max(max, dp[counsel[0]-1]+counsel[1]);
			}
			dp[i] = max;
		}

		System.out.println(dp[N]);
	}
}

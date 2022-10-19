package ps0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_10451_순열사이클_S3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			int nums[] = new int[N+1];
			boolean visited[] = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				list.add(i);
			}
			
			int cycle = 0;
			while(!list.isEmpty()) {
				cycle++;
				int idx = list.get(0);
				while(!visited[idx]) {					
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i)==idx) {
							list.remove(i);
							break;
						}
					}
					
					visited[idx] = true;
					idx = nums[idx];
					
				}
			}
			
			sb.append(cycle+"\n");
		}//for each test case
		System.out.println(sb);
	}
}

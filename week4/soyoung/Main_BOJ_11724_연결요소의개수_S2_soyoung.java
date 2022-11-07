package ps0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_11724_연결요소의개수_S2 {
	public static ArrayList<ArrayList<Integer>> nums;
	public static boolean[] visited;
	
	public static void dfs(int idx) {
		for (Integer n : nums.get(idx)) {
			if(!visited[n]) {
				visited[n] = true;
				dfs(n);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		
		nums = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			nums.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nums.get(u).add(v);
			nums.get(v).add(u);

		}
		
		
		visited = new boolean[N+1];
		int group = 0;
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				group++;
				visited[i] = true;
				dfs(i);
			}
		}
		System.out.println(group);
	}
}

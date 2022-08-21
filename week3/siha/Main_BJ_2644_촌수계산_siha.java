import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_2644_촌수계산_siha {
	
	static int N, p1, p2, M;
	static int x, y;
	static List<Integer> list[];
	static boolean[] visited;
	static int cnt = 0;
	static int res = -1;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		list = new LinkedList[N+1]; 
		visited = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new LinkedList();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		

		dfs(p1, p2);
		System.out.println(res);
		
	}

	private static void dfs(int start, int end) {
		
		if(start == end) {
			res = cnt;
			return;
		}		
		
		visited[start] = true;
		
		int now;
		for(int i=0;i<list[start].size();i++) {
			
			now = list[start].get(i);
			
			if(!visited[now]) {
				visited[now] = true;
				cnt++;
				dfs(now, end);
				cnt--;
			}
		}
		
	}
	

}

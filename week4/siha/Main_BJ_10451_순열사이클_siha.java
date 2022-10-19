import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_BJ_10451_순열사이클_siha {
	
	static int T, N;
	static int[] node;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			node = new int[N+1];
			visited = new boolean[N+1];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());			
			
			for(int i=1;i<N+1;i++) {				
				node[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i=1;i<N+1;i++) {
				if(!visited[i]) {
					dfs(i);	
					cnt+=1;
				}
			}
			
			System.out.println(cnt);
			
			
		}//end tc	
		
	}

	
	private static void dfs(int idx) {

		visited[idx] = true;		
				
		int now = node[idx];
		
		if(!visited[now]) {
			dfs(now);				
		}			
		else {
			return;
		}
		
	}

	

}

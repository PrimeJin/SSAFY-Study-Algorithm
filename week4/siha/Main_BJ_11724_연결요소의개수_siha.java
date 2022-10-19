import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_BJ_11724_연결요소의개수_siha {
	
	static int N, M;
	static List<Integer>[] node;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		node = new List[N+1];
		
		for(int i=0;i<N+1;i++) {
			node[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			node[u].add(v);
			node[v].add(u);
			
		}
		
		for(int i=1;i<N+1;i++) {
			if(!visited[i]) {
				dfs(i);	
				cnt+=1;
			}
		}
		
		System.out.println(cnt);
		
	}

	
	private static void dfs(int idx) {

		visited[idx] = true;
		
		for(int i=0;i<node[idx].size();i++) {
		
			int now = node[idx].get(i);
			
			if(!visited[now]) {
				dfs(now);				
			}			

		}
		
		
	}

	

}

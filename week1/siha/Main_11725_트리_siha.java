import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725_트리_siha {
	static int[] parents;
	static List<Integer>[] list;
	static boolean[] visit;
	static int n;
	
	private static void dfs(int v) {
		//방문했으니까 방문처리하고
		visit[v] = true;
		
		// 연결된 노드를 탐색한다. 
		for(int i : list[v]) { 
			if(!visit[i]) {	// 이미 방문한 노드가 아니라면
				parents[i] = v;		//부모노드이므로 추가 
				dfs(i); // 연결된 노드를 찾았으니 해당 노드부터 또 탐색 시작
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1]; 
		parents = new int[n+1];	//[0, 0, 0, 0, 0, 0, 0, 0]
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();	//[null, [], [], [], [], [], [], []]
		
		visit = new boolean[n+1];
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			list[a].add(b); list[b].add(a);
		}
		
		//1번 노드부터 시작
		dfs(1);
		for(int i = 2; i <= n; i++) System.out.println(parents[i]);
	}
}
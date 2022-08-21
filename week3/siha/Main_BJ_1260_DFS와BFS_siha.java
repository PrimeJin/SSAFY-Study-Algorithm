import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {
	
	static int N, M, V;
	static Queue<Integer> queue = new LinkedList<>();
	static LinkedList<Integer> stack[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		//dfs ================		
		stack = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			stack[i] = new LinkedList();			
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			stack[v1].add(v2);
			stack[v2].add(v1);
		}
		
		for(int i=0;i<stack.length;i++) {
			Collections.sort(stack[i]);
		}
		
		dfs(V);	
		sb.append("\n");

		//bfs =================
		
		visited = new boolean[N+1];	
		queue.add(V);
		bfs(V);
		
		
		
		
		System.out.println(sb);
		
	}//main
	



	private static void dfs(int start) {
		
		visited[start] = true;
//		System.out.print(start + " ");
		sb.append(start + " ");
		
		int now;
		for(int i=0;i<stack[start].size();i++) {
			now = stack[start].get(i);
			
			if(!visited[now]) {
				visited[now] = true;
				dfs(now);
			}			
		}
	}

	
	private static void bfs(int start) {
		
		visited[start] = true;

		
		while(!queue.isEmpty()) {
			int now = queue.poll();			
//			System.out.print(now + " ");
			sb.append(now + " ");
			
			for(int i=0;i<stack[now].size();i++) {
				if(!visited[stack[now].get(i)]) {
					queue.add(stack[now].get(i));
					visited[stack[now].get(i)] = true;
				}
			}
			
		}
		
	
	}


}

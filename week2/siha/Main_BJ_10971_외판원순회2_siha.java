import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BJ_10971_외판원순회_siha {	//최소 여행비용 구하기

	static int N;
	static int[][] city;
	static boolean[] visited;
	static int min_res = Integer.MAX_VALUE;
	static int cost;
	
	public static void main(String[] args) throws Exception{				

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		visited = new boolean[N];		//한번 갔던 도시는 다시 갈 수 없으므로 방문 체크 
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0;i<N;i++) {
			dfs(i, i, 0, 0);				
		}
		

		System.out.println(min_res);
	
	}//main	
	
	
	
	public static void dfs(int start, int now, int cnt, int cost) {
	
		if(cnt==N && start == now) {	//각 도시를 모두 방문했고 시작위치로 돌아왔을때 최소값 갱신
			min_res = Math.min(min_res, cost);			
			return;
		}

		
		for(int i=0;i<N;i++) {
			if(!visited[i] && city[now][i] != 0) {
				visited[i] = true;
				cost += city[now][i];
				dfs(start, i, cnt+1, cost);
				cost -= city[now][i];
				visited[i] = false;
			}
		}
		
		
	}//dfs	
	
}//end class




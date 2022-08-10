import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	static int[][] W;
	static boolean[] visited; 
	static int N;  //도시 수
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  //도시 수
		W = new int[N+1][N+1];  //도시간 이동 비용 배열 
		visited = new boolean[N+1];  //열 체크 boolean 배열 (한 열은 한번만 등장가능)
		
		//비용 초기화작업
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {  //시작점(행마다 반복)
			visited[i] = true;
			dfs(i,i,0,0);
			visited[i] = false;
			
		}
		
		System.out.println(min);
	}
	public static void dfs(int from, int to, int cost, int count) {
		if(count == N-1) {
			if(W[to][from]!=0) {  //도시로 갈수 없는 경우 제외
				cost += W[to][from];
				min = Math.min(min, cost);
			}
			return ;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && W[to][i]!=0 ) {
				visited[i] = true;
				dfs(from, i, cost+W[to][i], count+1);
				visited[i] = false;  //다 탐색한 후에는 false로 바꿔줘야 다른 경우 시작할 때 클린하게 시작
			}
			
		}
	}
}

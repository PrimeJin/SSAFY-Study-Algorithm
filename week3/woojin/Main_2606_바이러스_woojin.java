import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스_woojin {
	static boolean[][] connect;
	static boolean[] isChecked;
	static int N;
	static int M;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  //컴퓨터 수 
		M = Integer.parseInt(br.readLine());  //네트워크로 직접 연결되어 있는 컴퓨터 쌍 수
		
		connect = new boolean[N+1][N+1];
		isChecked = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			connect[x][y] = true;
			connect[y][x] = true;
		}
		
		dfs(1);
		System.out.println(count-1);  //1번 컴퓨터를 통해 바이러스 걸린 컴퓨터 이므로 1번 컴퓨터 제외(-1)
	}
	
	
	public static void dfs(int n) {
		count++;
		isChecked[n] = true;
		for(int i=1; i<=N; i++) {
			if(connect[n][i] && !isChecked[i]) {
				dfs(i);
			}
		}
	}
}	

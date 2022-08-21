import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_2606_바이러스_siha {
	
	static int comNum, conn, cnt;
	static List<ArrayList<Integer>> computer;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		comNum = Integer.parseInt(br.readLine());
		conn = Integer.parseInt(br.readLine());
		
		computer = new ArrayList<>();
		visited = new boolean[comNum+1];
		
		for(int i=0;i<=comNum;i++) {
			computer.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<conn;i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			computer.get(c1).add(c2);
			computer.get(c2).add(c1);
		}
		
		cnt = 0;
		dfs(1);
		
		System.out.println(cnt);
		
		
		
	}//main
	
	
	private static void dfs(int start) {
		
		visited[start] = true;
		
		int nowCom;
		
		for(int i=0;i<computer.get(start).size();i++) {
			nowCom = computer.get(start).get(i);
			
			if(!visited[nowCom]) {
				visited[nowCom] = true;
				cnt++;
				dfs(nowCom);
			}
			
			
		}
		
		
		
		
	}//end bfs
	
}//end class

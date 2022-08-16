package study0817;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2606_바이러스 {
	static Queue<Integer> q= new LinkedList<Integer>();
	static boolean[] visited;
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(ArrayList<Integer>[] in, int now) {
		visited[now]=true;
		for(int i=0;i<in[now].size();i++) {
			if(!visited[in[now].get(i)]) {//방문했으면
				q.add(in[now].get(i));//큐에 추가!
				dfs(in, in[now].get(i));//그 후 현재 방문한 노드 돌리기. 
			}
		}
	}
	
	static void printQ() throws IOException {
		while(!q.isEmpty()) {
			StringBuilder sb=new StringBuilder();
			sb.append(q.poll()+" ");
			bw.write(sb.toString());
		}
		bw.write("\n");
	}//dfs 잘되는지 체크해보는...

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(br.readLine());
		int r=Integer.parseInt(br.readLine());
		visited=new boolean[n+1];
		ArrayList<Integer>[] in=new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			in[i]=new ArrayList<Integer>();
		}//어레이 리스트 배열 사용법
		
		for(int i=0;i<r;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int tmp=Integer.parseInt(st.nextToken());
			int tmp2=Integer.parseInt(st.nextToken());
			in[tmp].add(tmp2);
			in[tmp2].add(tmp);
			//그래프는 단방향이 아니라 양방향이니까 양쪽으로 체크
		}
		
		for(int i=1;i<=n;i++) {
			visited[i]=false;
		}
		q.add(1);
		dfs(in, 1);
		//printQ();
		
		StringBuilder sb=new StringBuilder();
		sb.append((q.size()-1)+"\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

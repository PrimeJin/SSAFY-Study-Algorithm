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

public class b2644_촌수계산 {
	static int n;
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	//static Queue<Integer> q=new LinkedList<Integer>();
	
	static int bfs(int start, ArrayList<Integer>[] graph, int find) {
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] visited=new boolean[n+1];
		int[] whatChons=new int[n+1];
		for(int i=1;i<=n;i++) {
			visited[i]=false;
		}
		q.add(start);
		visited[start]=true;
		
		check:
		while(!q.isEmpty()) {
			int tmp1=q.poll();
			for(int i=0;i<graph[tmp1].size();i++) {
				int tmp2=graph[tmp1].get(i);
				if(!visited[tmp2]) {
					visited[tmp2]=true;
					whatChons[tmp2]=whatChons[tmp1]+1;
					q.add(tmp2);
					if(tmp2==find) {
						break check;
					}
				}
			}
		}
		
		if(whatChons[find]!=0) {
			return whatChons[find];
		}
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		int a,b;
		//두사람 
		StringTokenizer st=new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] graph=new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			graph[i]=new ArrayList<Integer>();
		}
		int m=Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int tmp1=Integer.parseInt(st.nextToken());
			int tmp2=Integer.parseInt(st.nextToken());
			graph[tmp1].add(tmp2);
			graph[tmp2].add(tmp1);
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(bfs(a, graph, b)+"\n");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}

}

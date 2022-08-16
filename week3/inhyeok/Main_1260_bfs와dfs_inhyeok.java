package study0817;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260_bfs와dfs {
	static Queue<Integer> q= new LinkedList<Integer>();
	static boolean[] visited;
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	//static int nowDepth=0;
	
	static void dfs(ArrayList<Integer>[] in, int now) {
		visited[now]=true;
		for(int i=0;i<in[now].size();i++) {
			if(!visited[in[now].get(i)]) {//방문했으면
				q.add(in[now].get(i));//큐에 추가!
				dfs(in, in[now].get(i));//그 후 현재 방문한 노드 돌리기. 
			}
		}
	}
	
	static void bfs(ArrayList<Integer>[] in, int start) {//in은 1에는 1번 노드와 연결된 숫자 2에는 2번노드와 연결된 숫자... 이런식으로 구성. start는 시작하는 숫자
		Queue<Integer> qu = new LinkedList<Integer>();//qu는 이 bfs함수에서 탐색 순서를 파악하기 위해서 사용하는 queue이다.
		visited[start]=true;//우선 시작숫자를 방문했으니까 visited에 방문했음을 표시
		qu.add(start);//탐색할거니까 큐에추가
		
		while(!qu.isEmpty()) {//큐가 빌떄까지(전부 탐색할떄까지 반복)
			int nodeIndex=qu.poll();//현재 탐색할 노드를 저장
			q.add(nodeIndex);//결과 큐에 추가
			for(int i=0;i<in[nodeIndex].size();i++) {//현재 탐색할 노드와 연결된 노드들 탐색해야함
				int tmp=in[nodeIndex].get(i);//가장 앞에 있는 노드부터 탐색 시작
				if(!visited[tmp]) {//이미 방문한 노드면 패스하고 방문안했으면 방문
					visited[tmp]=true;
					qu.add(tmp);//큐에 다음 탐색순서로 더해줌.
				}
				//이 다음으로 반복문이 돌기때문에 1번큐와 인접한 노드들이 먼저 큐에 들어가 있고,
				//그 다음 2번큐가 1번큐와 인접했다면 2번큐와 인접한 노드들이 그 다음으로 큐에 들어가 탐색 대상이 됨.
			}
		}
		//재귀가 아닌 반복문을 통해 설계
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
		
		
		StringTokenizer stt=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(stt.nextToken());
		int r=Integer.parseInt(stt.nextToken());
		int v=Integer.parseInt(stt.nextToken());
		
		visited=new boolean[n+1];
		ArrayList<Integer>[] in=new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			in[i]=new ArrayList<Integer>();
		}//어레이 리스트 배열 사용법
		//n번 노드에 n번쨰에 추가하기 위해서 이런식으로 사용했음
		
		for(int i=0;i<r;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int tmp=Integer.parseInt(st.nextToken());
			int tmp2=Integer.parseInt(st.nextToken());
			in[tmp].add(tmp2);
			in[tmp2].add(tmp);
			//그래프는 단방향이 아니라 양방향이니까 양쪽으로 체크
		}
		
		for(int i=0;i<=n;i++) {
			Collections.sort(in[i]);
		}//배열 안에 들어있는 숫자 정렬해줌 
		
		for(int i=1;i<=n;i++) {
			visited[i]=false;
		}
		q.add(v);
		dfs(in, v);
		printQ();
		
		for(int i=1;i<=n;i++) {
			visited[i]=false;
		}
		
		bfs(in,v);
		printQ();
		
		bw.flush();
		bw.close();
	}

}

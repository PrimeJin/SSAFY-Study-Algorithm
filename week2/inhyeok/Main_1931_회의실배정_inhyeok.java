package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1931_회의실배정2 {
	static int n;
	static List<Node> nodes=new ArrayList<Node>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			nodes.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(nodes);//끝나는 시간이 빠른순서로 정렬
		int nowEnd=nodes.get(0).end;//끝나는 시간이 가장 빠른걸 우선 채택한다.
		int ans=1;//한개의 회의를 채택했으므로 1부터 시작한다.
		
		for(int i=1;i<n;i++) {//정렬이 끝났다면 1회의 순회로 최적의 회의 개수를 찾을 수 있다.
			if(nowEnd<=nodes.get(i).start) {//현재 회의의 끝시간이 다음 회의의 시작시간보다 빠른시간이 되면 
				nowEnd=nodes.get(i).end; //다음회의의 끝시간으로 현재회의를 넘겨준다.
				ans+=1;//회의 개수를 추가한다.
			}
		}
		
		sb.append(ans+"\n");
		bw.write(sb.toString());//스트링 빌더도, 버퍼드 라이터도 크게 의미는 없지만 겉멋이다.
		bw.flush();
		bw.close();
	}

}

class Node implements Comparable<Node>{
	int start;
	int end;
	Node(){}
	Node(int start, int end){
		this.start=start;
		this.end=end;
	}
	@Override
	public int compareTo(Node o) {
		if(this.end==o.end) {
			return this.start-o.start;
			//end가 같으면 start에 대한 내림차순으로 정렬해준다. 사실 의미는 없고 겉멋이다.
		}
		return this.end-o.end;//end에 대한 오름차순으로 정렬하기 위함
	}
}

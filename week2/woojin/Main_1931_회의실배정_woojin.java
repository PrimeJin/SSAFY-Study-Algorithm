import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
	public int start, end;
	
	Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Time o) {
		if(this.end==o.end) {  //끝나는 시간이 같은 경우 시작하는 시간으로 오름차순
			return this.start - o.start;
		} else {  //끝나는 시간 다르면 끝나는 시간으로 오름차순
			return this.end - o.end;
		}
	}
}

class Main_1931_회의실배정 {
	public static int solution(ArrayList<Time> list, int n) {
		int count = 0;  //회의 개수
		Collections.sort(list);  //정렬작업
		int endTime = 0;  //누적된 회의 끝나는시간
		for(Time t : list) {
			if(t.start>=endTime) {
				count++;
				endTime = t.end;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());  //회의 수
		ArrayList<Time> list = new ArrayList<>();
		//회의시간 입력 (회의 추가)
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Time(start, end));
		}
		
		System.out.println(solution(list, N));
		
	}
}

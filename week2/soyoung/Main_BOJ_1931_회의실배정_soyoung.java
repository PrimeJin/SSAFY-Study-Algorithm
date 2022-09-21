import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * BOJ 1931. 회의실배정
 * - Greedy 알고리즘
 * - 각 상황에서의 최적의 경우를 선택 후 최적값이 맞는지 검사
 */

public class Main_BOJ_1931_회의실배정_S1 {
	public static final int START = 0;
	public static final int END = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		for (int i = 0; i < meetings.length; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i][START] = Integer.parseInt(st.nextToken()); //start time
			meetings[i][END] = Integer.parseInt(st.nextToken()); //end time
		}
		
		//시작시간 기준으로, 같을 경우 끝나는 시간 기준으로 정렬(Comparator Override)
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});
		
		//최대 회의 개수 count
		int cnt = 0;
		int end = -1;
		for (int i = 0; i < meetings.length; i++) {
			//이미 이전 회의가 끝났다면 추가
			if(meetings[i][START] >= end) {
				cnt++;
				end = meetings[i][END];
			}
			//이전 회의가 끝나지 않았지만 내가 더 먼저 끝난다면 끝나는 시간 변경
			else if(meetings[i][END] < end) {
				end = meetings[i][END];
			}
		}
		System.out.println(cnt);
	
	}//main
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main_BJ_1931_회의실배정_siha {

	public static void main(String[] args) throws Exception{				

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] meet;
		int count = 1;
		int end;
		
		
		int N = Integer.parseInt(br.readLine());
		meet = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			meet[i][0] = Integer.parseInt(st.nextToken());
			meet[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(meet, new Comparator<int[]>() {		//종료시간이 빠른순서대로 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		

		end = meet[0][1];
		
		for(int i=1;i<N;i++) {		//다음 회의 시작이 현재 종료시간보다 같거나 크면 count
			if(end <= meet[i][0]) {
				count++;
				end = meet[i][1];
			}
		}
		
		
		System.out.println(count);
		
	
	}//main	
	
}//end class




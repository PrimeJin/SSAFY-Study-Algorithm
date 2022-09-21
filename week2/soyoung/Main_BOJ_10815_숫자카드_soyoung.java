import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ 10815. 숫자카드
 * 이분탐색 활용
 *   => search(int[]arr, int start, int end)
 *   => 가운데 값 기준 왼/오른쪽 재귀적 호출
 */

public class Main_BOJ_10815_숫자카드_S5 {
	static int my[];
	
	//이분탐색으로 포함여부 확인
	public static int contains(int num, int start, int end) {
		if(start > end) return 0; //not found

		int mid = (start+end)/2; //mid index
		if(num == my[mid]) return 1; //find!
		else if(num < my[mid]) return contains(num, start, mid-1); //smaller than mid
		else return contains(num, mid+1, end); //larger than mid
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //상근이가 가진 카드 개수
		st = new StringTokenizer(br.readLine());
		my = new int[N];
		for (int i = 0; i < N; i++) {
			my[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(my); //이분탐색 하기 위하여 정렬
		int M = Integer.parseInt(br.readLine()); //가지고 있는지 확인할 카드 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(contains(Integer.parseInt(st.nextToken()), 0, N-1) + " ");
		}
		System.out.println(sb.toString());
	}//main
}

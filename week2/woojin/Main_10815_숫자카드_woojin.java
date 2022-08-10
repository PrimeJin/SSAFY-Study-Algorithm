import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] card = new int[N];
		//카드 숫자 초기화
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		//이분탐색을 위한 카드 정렬
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());  //주어진 정수 개수
		st = new StringTokenizer(br.readLine());  //정수 입력받기
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int lt = 0;
			int rt = N-1;
			boolean check = false;
			while(lt<=rt) {  //결국 왼쪽이 오른쪽 따라잡기 전까지 반복
				int mid = (lt+rt)/2;
				if(card[mid] == num) {  //중간값이 입력받은 정수인 경우 true로 설정
					check = true;
					break;
				}
				
				if(card[mid] > num) rt=mid-1;  //중간값이 입력받은 정수보다 크면 오른쪽 끝을 중간값-1로 설정해서 다시 탐색
				else lt = mid+1;  //반대로 중간값이 입력받은 정수보다 작으면 왼쪽 끝 lt를 중간값+1로 설정해서 다시 탐색
			}
			sb.append(check ? 1:0);  //탐색 종료 후 상근이가 갖고 있는 수면 1추가 아니면 0추가
			sb.append(" ");
		}  //주어진 정수 반복문 끝
		System.out.println(sb);
		 
	}
}

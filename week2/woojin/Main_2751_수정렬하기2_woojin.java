import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//방법1 Arrys.sort 사용
//		Arrays.sort(arr);
		
		
		//방법2 버블정렬 사용  (N^2 시간초과)
//		for(int i=0; i<N-1; i++) {
//			for(int j=i; j<N; j++) {
//				if(arr[i] > arr[j]) {
//					int temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		
		//방법3 Collections.sort 사용 
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine())); 
		}
		
		Collections.sort(list);
		
		
		
		//결과 출력
		StringBuilder sb = new StringBuilder();
		//방법 1,2 배열사용했을 경우
//		for(int i=0; i<arr.length; i++) {
//			sb.append(arr[i]);
//			sb.append("\n");
//		}
//		System.out.println(sb);
		
		//방법3 Collections.sort 결과 출력
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}

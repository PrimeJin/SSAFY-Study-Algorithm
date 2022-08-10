import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main_BJ_2751_수정렬하기2_siha {
	
	static int N;
	static int[] sorted;
	
	
	public static void main(String[] args) throws Exception{
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		sorted = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		
		mergeSort(arr, 0, N-1);
		
		for (int a : arr) {
			System.out.println(a);
		}
		
	}//main
	
	
	
	
	
	public static void mergeSort(int[] a, int left, int right) {
		
		if(left<right) {
		
			//배열을 둘로 나누기 - 원소가 1개가 될때까지 나누고, 합병하며 재귀를 빠져나오게 됨
			int middle = ( left + right ) / 2;
			mergeSort(a, left, middle);		//앞쪽 리스트 분리
			mergeSort(a, middle+1, right);	//뒤쪽 리스트 분리 
			
			merge(a, left, middle, right);  //분리된 두 배열을 정렬 및 합병
		}

		
		
	}//mergeSort
	
	
	
	public static void merge(int[] a, int left, int middle, int right) {
		
		int l_idx = left;
		int r_idx = middle+1;
		int s_idx = left;
			
		while(l_idx <= middle && r_idx <= right) {		// 크기 비교하며 정렬
			
			if(a[l_idx] <= a[r_idx]) {
				sorted[s_idx++] = a[l_idx++];
			}
			else {
				sorted[s_idx++] = a[r_idx++];
			}
				
		}
		
		
		//남은 원소가 있다면 추가
		
		if(l_idx > middle) {	//왼쪽 인덱스가 mid보다 크다면, 오른쪽 원소가 남은것이므로 
			for(int i=r_idx;i<=right;i++,s_idx++) {
				sorted[s_idx] = a[i];
			}
		}
		
		else {	//왼쪽 인덱스가 mid보다 작거나 같다면, 왼쪽 원소가 남은 것이므로
			for(int i=l_idx;i<=middle;i++,s_idx++) {
				sorted[s_idx] = a[i];
			}
		}
		
		
			
		for(int i=left;i<=right;i++) {	
			a[i] = sorted[i];		//정렬된 원소를 원래의 배열에 추가(현재 재귀의 left~right 범위에 맞춰서)
		}
		
		
		
	}//merge	
	
}//end class




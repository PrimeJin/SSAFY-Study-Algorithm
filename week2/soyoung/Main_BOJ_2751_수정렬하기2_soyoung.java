import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * BOJ 2751. 수 정렬하기 2
 * 분할정복 - Merge Sort 구현
 *   
 */

public class Main_BOJ_2751_수정렬하기2_S5 {
	public static int arr[];
	public static int sorted[]; //merge sort 저장할 추가 배열
	
	public static void mergeSort(int start, int end) {
		if(start >= end) return;
		int mid = (start+end)/2;
		mergeSort(start, mid); //왼쪽 분할 및 정렬
		mergeSort(mid+1, end); //오른쪽 분할 및 정렬
		merge(start, mid, end); //합병
	}
	
	public static void merge(int start, int mid, int end) {
		int i = start; //합병할 왼쪽 배열의 시작 인덱스
		int j = mid+1; //합병할 오른쪽 배열의 시작 인덱스
		
		int k = start; //합병 시작 인덱스(정렬될 배열 채우기 위한 인덱스 변수)
		while(i <= mid && j <= end) { //두 배열의 모든 원소를 모두 넣을 때까지
			//둘 중 더 작은 값 먼저 넣기(합병)
			if(arr[i] <= arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		//아직 들어가지 못한 원소가 있다면 복사
		if(i > mid) {
			while(j <= end) sorted[k++] = arr[j++];
		}
		else {
			while(i <= mid) sorted[k++] = arr[i++];
		}
		
		//정렬된 부분을 원래의 배열로 복사
		for (int k2 = start; k2 <= end; k2++) {
			arr[k2] = sorted[k2];
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sorted = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, N-1);
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb.toString());
	}//main
}

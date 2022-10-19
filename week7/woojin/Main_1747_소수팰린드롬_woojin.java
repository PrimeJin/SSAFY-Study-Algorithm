import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1747_소수팰린드롬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numN = Integer.parseInt(br.readLine());
		String N;
		String reverseN;
		while(true) {
			N = Integer.toString(numN);
			reverseN = new StringBuilder(N).reverse().toString();
			if(palindrome(N, reverseN)) {  //팰린드롬 체크
				if(prime(numN)) {
					break;
				}
			}
			numN++;  //1씩 증가시켜서 다음수 진행
		}
		System.out.println(numN);
	}
	
	
	public static boolean palindrome(String orig, String reverse) {
		if(orig.equals(reverse)) {
			return true;
		}
		return false;
	}
	public static boolean prime(int n) {
		boolean[] check = new boolean[n+1];
		
		check[1] = true;  //1은 소수가 아니므로 true로 미리 처리
		for(int i=2; i<n; i++) {
			if(!check[i]) {
				for(int j=i; j<n+1; j+=i) {
					check[j] = true;
				}
			}
		}
		
		if(!check[n]) return true;  //소수이면 return true;
		
		return false;
	}
	
}

package day1019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1747_소수팰린드롬 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int maxNum = Integer.MAX_VALUE;
		
		for(int i=Integer.parseInt(N);i<=maxNum;i++) {
			if(isPalin(Integer.toString(i)) && isPrime(i)) {
				System.out.println(i);
				System.exit(0);
			}
		}
		
	}

	

	private static boolean isPalin(String n) {		
		
		for(int i=n.length()-1, j=0;i>=0;i--,j++) {
			if(n.charAt(j)-'0' != n.charAt(i)-'0') return false;
		}		
		
		return true;
	}
	
	
	private static boolean isPrime(int n) {
		
		if(n==1)	return false;
		
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n % i == 0) return false;	
		}
		
		return true;		
			
	}
	
	
}

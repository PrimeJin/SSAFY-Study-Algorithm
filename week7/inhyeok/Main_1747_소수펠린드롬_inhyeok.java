package study1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b1747_소수펠린드롬 {
	
	public static boolean pal(int n) {
		boolean check=true;
		int jari=0;
		ArrayList<Integer> ns=new ArrayList<>();
		
		while(n/10!=0) {
			ns.add(n%10);
			n/=10;
			jari+=1;
		}
		ns.add(n);
		jari+=1;
		
		for(int i=0;i<jari/2;i++) {
			if(ns.get(i)!=ns.get(jari-i-1)) {
				check=false;
				break;
			}
		}
		
		return check;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr=new int[1221222];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int ans=0;
		
		arr[1]=-1;
		for(int i=2;i<=1221221;i++) {
			if(arr[i]!=-1) {
				arr[i]=1;
				for(int j=2;j*i<=1221221;j++) {
					if(j*i<=1221221&arr[i*j]!=-1) {
						arr[i*j]=-1;
					}
				}
			}
		}
		
		for(int i=n;i<=1221221;i++) {
			if(arr[i]!=-1 & pal(i)) {
				ans=i;
				break;
			}
		}
		
		System.out.println(ans);
		
		//1221221(이 수는 소수이며 팰린드롬)까지 소수를 저장한 배열 생성
		

	}

}

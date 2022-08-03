//링크드 리스트 기본개념, 활용

import java.util.LinkedList;
import java.util.Scanner;

public class b1406 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String all=sc.next();
		LinkedList<Character> b=new LinkedList<>();
		
		for(int i=0;i<all.length();i++) {
			b.add(all.charAt(i));
		}
		int now=b.size();
		
		
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String doit=sc.next();
			
			switch(doit) {
			case("L"):
				if(now>0) {now--;}
				break;
				
			
			case("D"):
				if(now<b.size()){now++;}
				break;
			
			case("B"):
				if(now!=0) {
					b.remove(now-1);
					now--;
				}
				break;
				
			case("P"):
				String a=sc.next();
				b.add(now, a.charAt(0));
				now++;
				break;
			}	
		}
		
		for(int i=0;i<b.size();i++) {
			System.out.print(b.get(i));
		}
		
		
		sc.close();
	}

}

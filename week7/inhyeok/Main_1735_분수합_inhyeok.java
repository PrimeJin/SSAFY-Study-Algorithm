package study1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1735_분수합 {

	public static void main(String[] args) throws IOException {
		int n,k;
		int n2,k2;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		n2=Integer.parseInt(st.nextToken());
		k2=Integer.parseInt(st.nextToken());
		
		int up=n*k2+n2*k;
		int down=k*k2;
		
		int tmp=Math.min(up, down);
		
		if(tmp==up) {
			for(int i=up;i>1;i--) {
				if(down%i==0 & up%i==0) {
					up/=i;
					down/=i;
					i=up;
				}
			}
		}
		else {
			for(int i=down;i>1;i--) {
				if(down%i==0 & up%i==0) {
					up/=i;
					down/=i;
					i=down;
				}
			}
		}
		
		System.out.println(up+" "+down);
	}

}

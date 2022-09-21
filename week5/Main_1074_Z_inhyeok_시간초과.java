package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class b1074_Z_시간초과 {
	
	static int ans=0;
	static int r=0;
	static int c=0;
	static int answer=0;
	public static void go(int leftUX, int leftUY, int leftDX, int leftDY, int rightUX,int rightUY, int rightDX, int rightDY) {
		int t=leftDX-leftUX+1;
		int n=(t/2)-1;
		if(leftDX-leftUX==1) {
			//2
			if(leftUX==r&leftUY==c) {
				ans+=1;
				answer=ans-1;
				return;
			}
			else {
				ans+=1;
			}
			//1
			if(rightUX==r&rightUY==c) {
				ans+=1;
				answer=ans-1;
				return;
			}
			else {
				ans+=1;
			}
			//3
			if(leftDX==r&leftDY==c) {
				ans+=1;
				answer=ans-1;
				return;
			}
			else {
				ans+=1;
			}
			//4
			if(rightDX==r&rightDY==c) {
				ans+=1;
				answer=ans-1;
				return;
			}
			else {
				ans+=1;
			}
		}
		else {
			//go(int leftUX, int leftUY, int leftDX, int leftDY, int rightUX,int rightUY, int rightDX, int rightDY)
			
			//2사분면(Z자로 가니까 2134)
			go(leftUX,leftUY,leftUX+n,leftUY,leftUX,leftUY+n,leftUX+n,leftUY+n);
			//1사분면
			go(rightUX,rightUY-n,rightUX+n,rightUY-n,rightUX,rightUY,rightUX+n,rightUY);
			//3사분면
			go(leftDX-n,leftDY,leftDX,leftDY,leftDX-n,leftDY+n,leftDX,leftDY+n);
			//4사분면
			go(rightDX-n,rightDY-n,rightDX,rightDY-n,rightDX-n,rightDY,rightDX,rightDY);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		int k=(int) Math.pow(2, n);
		
		//go(int leftUX, int leftUY, int leftDX, int leftDY, int rightUX,int rightUY, int rightDX, int rightDY)
		go(0,0,k-1,0,0,k-1,k-1,k-1);
		
		System.out.println(answer);
	}

}


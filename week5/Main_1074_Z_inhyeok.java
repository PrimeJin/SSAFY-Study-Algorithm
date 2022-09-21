package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class b1074_Z {
	
	static int ans=0;
	static int r=0;
	static int c=0;
	static int answer=0;
	
	public static boolean isitin(int leftUX, int leftUY, int leftDX, int leftDY, int rightUX,int rightUY, int rightDX, int rightDY) {
		if(r>=leftUX & r<=leftDX & c>=leftUY & c<=rightDY) {
			return true;
		}
		return false;
	}
	
	public static void go(int leftUX, int leftUY, int leftDX, int leftDY, int rightUX,int rightUY, int rightDX, int rightDY) {
		if(answer!=0)
			return;
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
			if(isitin(leftUX,leftUY,leftUX+n,leftUY,leftUX,leftUY+n,leftUX+n,leftUY+n)) {
				go(leftUX,leftUY,leftUX+n,leftUY,leftUX,leftUY+n,leftUX+n,leftUY+n);
			}
			else {
				ans=ans+(t*t/4);
			}
			
			//1사분면
			if(isitin(rightUX,rightUY-n,rightUX+n,rightUY-n,rightUX,rightUY,rightUX+n,rightUY)) {
				go(rightUX,rightUY-n,rightUX+n,rightUY-n,rightUX,rightUY,rightUX+n,rightUY);
			}
			else {
				ans=ans+(t*t/4);
			}
			
			//3사분면
			if(isitin(leftDX-n,leftDY,leftDX,leftDY,leftDX-n,leftDY+n,leftDX,leftDY+n)) {
				go(leftDX-n,leftDY,leftDX,leftDY,leftDX-n,leftDY+n,leftDX,leftDY+n);
			}
			else {
				ans=ans+(t*t/4);
			}
			//4사분면
			if(isitin(rightDX-n,rightDY-n,rightDX,rightDY-n,rightDX-n,rightDY,rightDX,rightDY)) {
				go(rightDX-n,rightDY-n,rightDX,rightDY-n,rightDX-n,rightDY,rightDX,rightDY);
			}
			else {
				ans=ans+(t*t/4);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		int k=(int) Math.pow(2, n);
		StringBuilder sb=new StringBuilder();
		
		//go(int leftUX, int leftUY, int leftDX, int leftDY, int rightUX,int rightUY, int rightDX, int rightDY)
		go(0,0,k-1,0,0,k-1,k-1,k-1);
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

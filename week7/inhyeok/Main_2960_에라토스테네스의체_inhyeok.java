package study1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b2960_에라토스테네스의체 {
	public static void main(String[] args) throws IOException {
		int n,k;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[1001];
		int ans=0;
		check:
		for(int i=2;i<=n;i++) {
			if(k==0) {
				break check;
			}
			if(arr[i]!=-1) {
				arr[i]=-1;
				k-=1;
				ans=i;
				for(int j=2;j*i<=n;j++) {
					if(j*i<=n&arr[i*j]!=-1) {
						arr[i*j]=-1;
						k-=1;
						ans=i*j;
						if(k==0) {
							break check;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}

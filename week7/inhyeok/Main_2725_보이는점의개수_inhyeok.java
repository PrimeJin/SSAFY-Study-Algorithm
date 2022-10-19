package study1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2725_보이는점의개수 {
	public static int checkCG(int n,int k){
		int tmp=n;
		int ans=1;
		
		while(tmp!=0) {
			if(n%k!=0) {
				int tmp2=n%k;
				n=k;
				k=tmp2;
			}
			else {
				ans=k;
				break;
			}
		}
		
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		
		int tc;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		tc=Integer.parseInt(st.nextToken());
		
		//결국 구하는 것은 원점에서 다른점과 선을 연결할떄
		//발생하는 기울기의 개수인 것 
		//그렇다면 기울기는 뭘까? x/y지 뭐긴 뭐야 
		//결국 이 문제는 x와 y가 n안에 있을 때
		//그 안에서 만들어질 수 있는 중복되지 않는 분수, 자연수의 개수이다.
		//결국 그럼 기약분수의 개수인듯?
		//1 이하의 기약분수를 다구한후 *2 하고 +1하면 답
		//기약분수는 분모와 분자의 최대공약수가 1이되어야함 
		int[][] arr=new int[1001][1001];
		for(int i=1;i<1001;i++) {
			for(int j=1;j<i;j++) {
				arr[i][j]=checkCG(i,j);
			}
		}
		
		for(int t=1;t<=tc;t++) {
			int ans=0;
			int n=Integer.parseInt(br.readLine());
			for(int i=1;i<=n;i++) {
				for(int j=1;j<i;j++) {
					if(arr[i][j]==1) {
						ans+=1;
					}
				}
			}
			ans=ans*2+3;
			//3더하는 이유 기울기 1,0,무한대
			System.out.println(ans);
			
		}
	}

}

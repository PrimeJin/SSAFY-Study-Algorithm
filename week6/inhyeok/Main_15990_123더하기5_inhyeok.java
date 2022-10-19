package study1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15990_123더하기5 {
	static long[][] arr=new long[100001][4];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		arr[1][1]=1;//1
		arr[1][0]=1;
		
		arr[2][2]=1;
		arr[2][0]=1;
		//2
		arr[3][3]=1;
		arr[3][2]=1;
		arr[3][1]=1;
		arr[3][0]=3;
		//3 2+1 1+2
		
		//와 이거 어케 제거하지 중복 
		
//		arr[4][3]=arr[1][1]+arr[1][2];//뒷자리 숫자가 3일경우 3인숫자는 불가능
//		arr[4][1]=arr[3][2]+arr[3][1];//뒷자리 숫자가 1일경우 1인 숫자 불가
//		arr[4][2]=arr[2][1]+arr[2][3];//뒷자리 숫자가 2일경우 2인숫자 불가
//		arr[4][0]=arr[4][1]+arr[4][2]+arr[4][3];
		
		for(int i=4;i<=100000;i++) {
			for(int j=1;j<4;j++) {
				for(int k=1;k<4;k++) {
					if(j!=k) {
						arr[i][j]=(arr[i][j]+arr[i-j][k])%1000000009;
					}
				}
			}
			arr[i][0]=(arr[i][1]+arr[i][2]+arr[i][3])%1000000009;
		}
		
		for(int i=0;i<n;i++) {
			int a=Integer.parseInt(br.readLine());
			System.out.println(arr[a][0]%1000000009);
		}
		
	}

}
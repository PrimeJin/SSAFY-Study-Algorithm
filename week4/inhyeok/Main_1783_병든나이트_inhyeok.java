package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1783_병든나이트 {
	
	static int[] movesN= {2,-2,1,-1};
	static int[] movesM= {1,1,2,2};

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		
		int move=0;
		int nown=1;
		int nowm=1;
		
		if(m>=7 & n>=3) {
			nowm=7;
			move=4;
		}
		//다시처리해야할듯 4이하면 제약조건 없음 
		else {
			if(n>=3) {
				if(m>=4) {
					move=3;
					nowm=4;
				}
				else {
					move=move+m-1;
				}
			}
			else {
				if(n>=2) {
					if(m>=7) {
						move=3;
					}
					else if(m>=5) {
						move=2;
					}
					else if(m>=3) {
						move=1;
					}
				}
			}
			System.out.println(move+1);
			return;
		}
		
		move=move+m-7;
		System.out.println(move+1);
		
		return;
	}

}

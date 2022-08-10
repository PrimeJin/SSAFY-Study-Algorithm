package study;
//이진트리 만들어서 하자

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b10815_숫자카드_withBtree {
	static int n;
	static int m;
	static tree T=new tree();
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		
		
		n=Integer.parseInt(br.readLine());
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		
		TreeSet<Integer> had=new TreeSet<Integer>();
		
		for(int i=0;i<n;i++) {
			had.add(Integer.parseInt(st.nextToken()));
		}
		
		m=Integer.parseInt(br.readLine());
		str=br.readLine();
		st=new StringTokenizer(str);
		
		int[] input=new int[m];
		int[] ans=new int[m];
		//답이 들어가는 배열(0,1)
		for(int i=0;i<m;i++) {
			input[i]=Integer.parseInt(st.nextToken());
			if (had.contains(input[i])) {
				ans[i]=1;
			}
		}
		
		

		
		
		
		for(int i=0;i<m;i++) {
			sb.append(ans[i]+" ");
		}
		sb.append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
class tree{
	int value;
	tree right;
	tree left;
	tree(){}
	tree(int value){
		this.value=value;
	}
}

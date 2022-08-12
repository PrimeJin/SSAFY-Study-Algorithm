package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class b10971_외판원순회 {
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<int[]> perL=new ArrayList<>();
	static ArrayList<Integer> ansL=new ArrayList<>();
	static int graph[][];
	static int n;
	
	static void per(int[] arr,boolean[] visited, int[] output, int depth, int n, int r) {
		if(depth==r) {
			int[] tmp=new int[r];
			for(int i=0;i<r;i++) {
				tmp[i]=output[i];
			}
			perL.add(tmp);
		}
		else {
			for(int i=0;i<n;i++) {
				if(visited[i]==false) {
					visited[i]=true;
					output[depth]=arr[i];
					per(arr,visited,output,depth+1,n,r);
					visited[i]=false;
				}
			}
		}
	}
	
	static int makeAns() {
		int ans=2147483647;
		for(int i=0;i<perL.size();i++) {
			int start=0;
			int prev=0;
			int nowsum=0;
			boolean check=true;
			check1:
			for(int j=0;j<n;j++) {
				if(j==0) {
					start=perL.get(i)[j];
					prev=perL.get(i)[j];
				}
				else {
					if(graph[prev][perL.get(i)[j]]!=0) {
						nowsum+=graph[prev][perL.get(i)[j]];
						prev=perL.get(i)[j];
					}
					else {
						check=false;
						break check1;
						}
				}
			}
			if(check==true) {
				if(graph[prev][start]!=0) {
					nowsum+=graph[prev][start];
					if(ans>nowsum){
						ans=nowsum;
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		graph=new int[n][n];
		int[] output=new int[n];
		boolean[] visited=new boolean[n];
		
		
		for(int i=0;i<n;i++) {
			arr[i]=i;
		}
		
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		per(arr,visited, output, 0, n, n);
		
		StringBuilder sb=new StringBuilder();
		sb.append(makeAns()+"\n");
		bw.write(sb.toString());
		
		
		
		
		bw.flush();
		bw.close();
	}

}

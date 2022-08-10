package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class b2751_수정렬하기_count {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		HashMap<Integer, Integer> cnt = new HashMap<>();
		
		for(int i=-1000001;i<1000001;i++) {
			cnt.put(i, 0);
		}
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			int tmp=cnt.get(arr[i]);
			cnt.put(arr[i], tmp+1);
		}
		
		for(int i=-1000001;i<1000001;i++) {
			if(cnt.get(i)!=0)
			{
				for(int j=0;j<cnt.get(i);j++) {
					bw.write(i+"\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		

	}

}

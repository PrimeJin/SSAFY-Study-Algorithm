package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class b1744_수묶기 {
	static ArrayList<Integer> pl=new ArrayList<>();
	static ArrayList<Integer> mi=new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			Integer tmp=Integer.parseInt(br.readLine());
			if(tmp>0) {
				pl.add(tmp);
			}
			else {
				mi.add(tmp);
			}
		}
		
		Collections.sort(pl, Collections.reverseOrder());
		Collections.sort(mi);
		
		while(pl.size()>=2) {
			if(pl.get(0)==1||pl.get(1)==1) {
				for(int i=0;i<pl.size();i++) {
					sum+=pl.get(i);
				}
				break;
			}
			else {
				sum+=pl.get(0)*pl.get(1);
				pl.remove(0);
				pl.remove(0);
			}
		}
		if(pl.size()==1) {
			sum+=pl.get(0);
		}
		
		while(mi.size()>=2) {
			sum+=mi.get(0)*mi.get(1);
			mi.remove(0);
			mi.remove(0);
		}
		
		if(mi.size()==1) {
			sum+=mi.get(0);
		}
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		sb.append(sum);
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}

}

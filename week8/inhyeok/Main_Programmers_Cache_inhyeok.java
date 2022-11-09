import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        TreeSet<String> cache=new TreeSet<String>();
        int nowSize=0;
        int answer = 0;
        int citySize=cities.length;
        ArrayList<String> recentC=new ArrayList<>();
        
        for(int i=0;i<citySize;i++){
        	cities[i]=cities[i].toLowerCase();
        }
        
        for(int i=0;i<citySize;i++){
            if(cache.contains(cities[i])) {
            	answer+=1;
            	recentC.remove(cities[i]);
            	recentC.add(cities[i]);
            	//갱신
            }
            else {
            	answer+=5;
            	if(nowSize<cacheSize) {
            		cache.add(cities[i]);
            		recentC.add(cities[i]);
            		nowSize+=1;
            	}
            	else if(cacheSize!=0){
            		cache.remove(recentC.get(0));
            		recentC.remove(0);
            		cache.add(cities[i]);
            		recentC.add(cities[i]);
            	}
            }
        }
        
        
        return answer;
    }
}

public class programmers_cache {
	static int cacheSize=2; 
	static String[] cities= {"Jeju", "Pangyo", "NewYork", "newyork"};
	static Solution s=new Solution();
	
	public static void main(String[] args) {
		System.out.println(s.solution(cacheSize, cities));
	}
}

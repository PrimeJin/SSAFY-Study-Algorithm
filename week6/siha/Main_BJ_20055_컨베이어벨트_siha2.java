

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20055_컨베이어벨트_siha2 {
	
	static int N, K;
	static ArrayList<Robot> belt = new ArrayList<>();
	static boolean flag;
	static int res = 1;
	
	static class Robot{		

		int dura;
		boolean isRobot;
		//순서를 지정해줘야하는줄 알았으나 역순으로 탐색 시 자동으로 순서파악이 되므로 변수 추가 X 
		
		public Robot(int dura, boolean isRobot) {
			super();
			this.dura = dura;
			this.isRobot = isRobot;
		}
		
	} 
	
	
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
       
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<2*N;i++) {
        	int dura = Integer.parseInt(st.nextToken());
        	belt.add(new Robot(dura, false));
        }
        
        
        
        //이 문제에서 말하는 단계는 각각 메서드의 단계가 아니라, 
        //아래의 while문을 한바퀴 도는것, 즉 각 스텝을 모두 수행하는것을 뜻함 
        while(true) {     	
        	
        	
        	//벨트 회전
        	rotate();        	
        	
    		moveRobot();
        	
        	//로봇올리기
        	updateRobot();
        	
        	
        	//내구도 칸 개수 체크 
        	flag = checkDurability();        	        	
        	
        	
        	//flag == true : K조건 만족, 종료)
        	if(flag)	break;
        	else	res += 1;
        	
        }
        
        
        System.out.println(res);
        
        
	}//main
	
	
	
	private static void downRobot() {
		
		if(belt.get(N-1).isRobot) {
			belt.get(N-1).isRobot = false;		
		}
	}
	
	
	
	private static void rotate() {
		
		//LinkedList는 시간초과 발생
		
		/*
		  <참고>
		   연결리스트의 끝과 끝에서 삽입 삭제가 빈번하게 일어나는 경우, LinkedList를 사용하는것이 효과적이나, 
		  get, set등의 값을 가져오는 행위나 값을 삽입하는 것이 빈번할 경우 ArrayList가 효과적이다. 
		  (LinkedList의 경우 get을 할 때 첫 노드부터 모두 탐색하여 가져오기때문에 O(n)의 시간이 걸림,
		  ArrayList에서 get은 인덱스를 통해 바로 값을 찾아오기때문에 O(1)의 시간이 걸린다.)
		  
		   본 문제에서는 rotate()를 제외하고 get을 매우 많이 사용하므로  ArrayList를 사용해야 시간초과가 나지 않는다. 		  
		 */
		
		belt.add(0, belt.get(belt.size()-1));
		belt.remove(belt.size()-1);
		
		downRobot();
		
	}
	
	private static void moveRobot() {
		
		/*
		  가장 먼저 올라온 로봇부터 이동해야한다 == N-1번째에서 로봇이 내려가므로, N번째부터는 로봇이 존재할 수 없음.
		  따라서, N번째부터는 애초에 로봇이 올라갈 수 없으므로 탐색 X,
		       N-2번째부터 첫번째 자리까지 역순으로 탐색해주면 가장 먼저 올라온 로봇부터 탐색할 수 있음		 
		*/
		
		for (int i = N - 2; i >= 0; i--) {
			
			// 로봇이 존재할 경우
			if (belt.get(i).isRobot) {	
				if (i + 1 == N-1) {
					if (belt.get(i+1).dura > 0) {
						belt.get(i).isRobot = false;
						belt.get(i+1).dura--;
						continue;
					}
				}
				
				//로봇이 존재하는데 이동할 수 없는 경우 continue
				if (belt.get(i+1).isRobot || belt.get(i+1).dura == 0)		continue;
				
				
				//로봇이 존재하고 이동할 수 있는 경우 상태를 변화시킴
				belt.get(i+1).isRobot = true;
				belt.get(i+1).dura--;
				belt.get(i).isRobot = false;
				
			}
		}
		
	}
	
	
	//로봇 올리기
	private static void updateRobot() {
		
		if(belt.get(0).dura != 0) {
			
			belt.get(0).dura -= 1;
			belt.get(0).isRobot = true;

		}
		
		
	}

	
	//내구성 남아있는 칸 조사
	private static boolean checkDurability() {

		int tmp = 0;
		
		for(int i=0;i<belt.size();i++) {
			if(belt.get(i).dura == 0) {
				tmp += 1;
				
				//내구성이 0인 칸이 K와 동일하게 되는 순간 종료
				if(tmp == K) {
					return true;
				}
			}
			
		}
		
		
		return false;
		
	}

	

	
	
}

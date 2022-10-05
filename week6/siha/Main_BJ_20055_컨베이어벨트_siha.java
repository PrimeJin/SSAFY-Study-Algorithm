
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_20055_컨베이어벨트_siha {
	
	static int N, K;
	static LinkedList<Robot> belt = new LinkedList<>();
	static int robotCnt;
	static boolean flag;
	static int res = 0;
	
	static class Robot{
		
		//order == 0이면  로봇이 없다는뜻 
		//order == 1부터 순서 적용
		int dura, order;
		boolean isRobot;
		
		public Robot(int dura, boolean isRobot, int order) {
			super();
			this.dura = dura;
			this.isRobot = isRobot;
			this.order = order;
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
        	belt.add(new Robot(dura, false, 0));
        }
        
        
        while(!flag) {
        	
        	res += 1;
        	
        	//벨트 회전
        	rotate();        
        	
        	//로봇이 존재하면 로봇 이동
        	if(robotCnt != 0) {
        		moveRobot();
        	}
        	
        	//로봇올리기
        	updateRobot();
        	
        	//내구도 칸 개수 체크
        	flag = checkDurability();        	        	
        	
        }
        
        System.out.println(res);
        
        
	}
	
	
	
	private static void downRobot() {
		
		if(belt.get(N-1).isRobot) {
			belt.get(N-1).isRobot = false;
			belt.get(N-1).order = 0;
			robotCnt -= 1;
			
			for(int i=0;i<belt.size();i++) {
				if(belt.get(i).order > 0) {
					belt.get(i).order -= 1;
				}
			}
			
		}
	}

	
	
	private static void rotate() {
		
		belt.addFirst(belt.get(belt.size()-1));
		belt.removeLast();		
		
		//로봇 내리는 함수
		downRobot();
		
	}
	
	
	
	private static void moveRobot() {
		
		int num = 1;
		
		int i = 0;
		
		while(num <= robotCnt) {
			
			if(i == N-1) {
				i += 1;
				continue;
			}
			
			
			Robot robot = belt.get(i);
		
			if(robot.isRobot && robot.order == num) {
				
				//로봇이 존재하는데 그게 내리는곳 직전일경우 
				if(i == N-2) {
					
					robot.isRobot = false;
					robot.order = 0;
					belt.get(N-1).dura -= 1;
					robotCnt -= 1;					
					
					i+=1;
										
					continue;
				}
				
				
				//그게 아니면 넘어감 
				
				Robot nextRobot;
				
				
				if(i+1 == belt.size()) {
					nextRobot = belt.get(0);
				}else {
					nextRobot = belt.get(i+1);					
				}
				
				if(!nextRobot.isRobot && nextRobot.dura >= 1) {
					
					if(i==belt.size()-1) {
						belt.get(0).isRobot = true;
						belt.get(0).dura -= 1;
						belt.get(0).order = num;
					}
					else {
						belt.get(i+1).isRobot = true;
						belt.get(i+1).dura -= 1;
						belt.get(i+1).order = num;
					}
					
					
					belt.get(i).isRobot = false;
					belt.get(i).order = 0;
				}
			
				num+=1;
				
				
			}
			
				
			if(i+1 == belt.size()) {
				i = 0;
			}
			else{
				i+=1;
			}
		
			
			
		}
		
		
	}
	
	
	private static void updateRobot() {
		
		if(belt.get(0).dura > 0) {
			
			robotCnt += 1;
			
			belt.get(0).dura -= 1;
			belt.get(0).isRobot = true;
			belt.get(0).order = robotCnt;
		}
	}
	
	

	private static boolean checkDurability() {

		int tmp = 0;
		
		for(int i=0;i<belt.size();i++) {
			
			
			
			if(belt.get(i).dura == 0) {
				tmp += 1;
			}
			
		}
		
		
		if(tmp == K) {
			 return true;
		}
		else		return false;
		
	}

	

	

	
	
	
	
}

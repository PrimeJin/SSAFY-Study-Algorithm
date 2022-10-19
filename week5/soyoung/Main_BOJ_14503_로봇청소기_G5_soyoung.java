import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_G5 {
    static int N, M, count, map[][];
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    static Robot robot;

    static class Robot{
        int r, c, face;
        public Robot(int r, int c, int face) {
            this.r = r;
            this.c = c;
            this.face = face;
        }

        //로봇 위치 이동 및 로봇 방향 회전하는 함수
        public void move(int direction, int face) {
//            System.out.println("move!! direction: "+direction+" and face: "+face);
            int y = r, x = c;
            switch (direction) {
                case UP:
                    y--;
                    break;
                case RIGHT:
                    x++;
                    break;
                case DOWN:
                    y++;
                    break;
                case LEFT:
                    x--;
                    break;
            }
            this.r = y;
            this.c = x;
            this.face = face;
        }
    }

    //현재 위치 (r,c) 를 기준으로 원하는 방향에 무엇이 있는지 확인하는 함수
    //리턴: 벽이라면 1, 청소 안 한 곳이면 0, 청소한 곳이면 2
    public static int check(int r, int c, int direction) {
        int y = r, x = c;
        switch(direction) {
            case UP:
                y--;
                break;
            case RIGHT:
                x++;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
        }
        return map[y][x];
    }

    public static void cleanUp(){
        while(true){

            int curr = robot.r;
            int curc = robot.c;
            int curDir = robot.face;

//            System.out.println("my location: ("+curr+", "+curc+") and my face: "+curDir);

            //1. 로봇 현재 위치 청소 및 칸 개수 업데이트
            if(map[curr][curc] == 0) {
                map[curr][curc] = 2;
                count++;
            }

            //2. 탐색 및 이동
            //2-1) 탐색
            int goDir = -1;
            for (int i = 0; i < 4; i++) {
                int checkDir = ((curDir-i)-1+4)%4; //현재 기준 왼쪽 방향
                if(check(curr, curc, checkDir)==0) { //청소할 수 있는 칸 찾으면 그 방향 기억하고 빠져나가기
                    goDir = checkDir; //기억
                    break;
                }
            }

            //2-2) 이동(갈 방향 갱신 후 -> 이동)
            //찾았다면(goDir 갱신 여부로 파악) (방향도 변경, 위치도 변경)
            if(goDir >= 0) { //이동
                robot.move(goDir, goDir);
            } else { //못찾았다면 후진(방향은 그대로, 위치만 뒤로)
                //후진 가능 여부 확인
                goDir = (curDir-2+4)%4; //반대 방향
                if(check(curr, curc, goDir)==1) { //뒤가 벽이라면 청소 끝
                    return;
                } else { //후진 가능하다면
                    robot.move(goDir, curDir);
                }

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        robot = new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로봇청소기 청소 시작
        cleanUp();

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        //결과 출력
        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_21610_마법사상어와비바라기_G5 {
    static int N, M, map[][], d, s;
    static ArrayList<Cloud> cloudList;

    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static class Cloud {
        int r, c;

        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }


        public void move(int d, int s) {
            int ny = this.r + dy[d] * s;
            int nx = this.c + dx[d] * s;

            //경계 밖 보정
            while(ny < 0) ny += N;
            while(ny >= N) ny -= N;
            while(nx < 0) nx += N;
            while(nx >= N) nx -= N;

            this.r = ny;
            this.c = nx;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloudList = new ArrayList<>();

        //최초 구름 추가
        cloudList.add(new Cloud(N-1, 0));
        cloudList.add(new Cloud(N-1, 1));
        cloudList.add(new Cloud(N-2, 0));
        cloudList.add(new Cloud(N-2, 1));

        boolean[][] visited = new boolean[N][N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
//            System.out.println((m+1)+"번째 이동: "+d+" 방향으로 "+s+"번 이동");

            //모든 구름에 대해 이동 및 비내리기
            for (Cloud cloud : cloudList) {
                cloud.move(d, s); //이동
                map[cloud.r][cloud.c]++; //비내리기
            }

            //모든 구름에 대해 물복사
            for (Cloud cloud : cloudList) {
                int cnt = 0;
                for (int i = 2; i <= 8; i+=2) {
                    int ny = cloud.r+dy[i];
                    int nx = cloud.c+dx[i];
                    if(((ny>=0)&&(nx>=0)&&(ny<N)&&(nx<N)) && map[ny][nx]>0) { //범위 내에 있고 물이 있다면
                        cnt++;
                    }
                }
                map[cloud.r][cloud.c] += cnt; //물복사
                visited[cloud.r][cloud.c] = true; //전 단계에 구름이 있었음을 기억
            }

            //모든 구름 삭제
            cloudList = new ArrayList<>();

            //맵의 모든 위치에 대해
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //전 단계에 구름이 있었다면 그냥 넘어가기(다음 단계를 위해 기억 삭제)
                    if(visited[i][j]) {
                        visited[i][j] = false;
                        continue;
                    }
                    //전 단계에 구름이 없었고 물이 >=2 라면 구름 생성
                    if(map[i][j] >= 2) {
                        cloudList.add(new Cloud(i, j)); //구름 생성
                        map[i][j] -= 2; //물 -2
                    }
                }
            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }

        }//다음 이동으로

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }//main
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* BOJ 2146. 다리만들기
*
* */
public class Main_BOJ_2146_다리만들기_G3 {
    static int N;
    static Node map[][];
    static boolean visited[][];

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static int minBridge = Integer.MAX_VALUE;


    static class Node {
        int r, c, status;

        public Node(int r, int c, int status) {
            this.r = r;
            this.c = c;
            this.status = status;
        }
    }

    //dfs 수행하며 섬 번호 갱신
    public static void setIslandNum(int r, int c, int islandNum){
        //guswo
        map[r][c].status = islandNum;

        for (int i = 0; i < 4; i++) {
            int ny = r+dy[i];
            int nx = c+dx[i];

            //IndexOutOfBounds 검사
            if(ny<0 || nx<0 || ny >= N || nx>= N) continue;

            //아직 방문 안한 + 섬인곳으로만 진행
            if(map[ny][nx].status==1 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                setIslandNum(ny, nx, islandNum);
            }

        }

    }

    //해당 칸에서 bfs 시작하여 다른 섬까지의 최단경로 리턴, 찾지 못하거나 중간에 포기할 시 Integer.MAX_VALUE;
    public static int bfs(int r, int c, int islandNum) {
        Queue<Node> list = new LinkedList<>();
        visited[r][c] = true;
        list.add(map[r][c]);

        int bfsLevel = -1;
        while(!list.isEmpty()) {
            int curSize = list.size(); //bfs level
            bfsLevel++;

            //가지치기2) 현재 탐색중인 다리의 길이가 현재 최소 다리보다 길면 탐색 포기
            if(bfsLevel > minBridge) return bfsLevel;

            //현재 노드에서 유효한 인접 노드 큐에 추가
            for (int i = 0; i < curSize; i++) {
                Node curNode = list.poll();

                //인접노드 탐색 후 큐에 추가, 가지치기1) 위로 갈 필요 없음
                for (int j = 1; j < 4; j++) {
                    int ny = curNode.r + dy[j];
                    int nx = curNode.c + dx[j];

                    //IndexOutOfBounds 검사
                    if(ny<0 || nx<0 || ny >= N || nx>= N) continue;

                    //아직 방문 안한 + 바다인 곳으로 bfs 진행
                    if(map[ny][nx].status==0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        list.add(map[ny][nx]);
                    }

                    //다른 섬 발견하면 bfs 종료
                    if(map[ny][nx].status != 0 && map[ny][nx].status != islandNum) {
                        return bfsLevel;
                    }
                } //현재 노드에 대한 인접노드 추가 for
            } //현재 레벨에 있는 모든 노드에 대한 bfs 탐색 for

        }//while

        //찾으면 path 갱신

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //input
        N = Integer.parseInt(br.readLine());
        map = new Node[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        //섬마다 구역 나누기(dfs 수행)
        visited = new boolean[N][N];
        int islandNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].status==1 && !visited[i][j]) { //섬이고 아직 번호 지정 안했으면
                    islandNum++;
                    visited[i][j] = true;
                    setIslandNum(i, j, islandNum);
                }
            }
        }


        //bfs 돌면서 최단 거리 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].status != 0) { //섬이고 아직 bfs 안했으면
                    visited = new boolean[N][N];
                    int curBridge = bfs(i, j, map[i][j].status);

                    //최단 다리 갱신
                    minBridge = Math.min(minBridge, curBridge);
                }
            }
        }


//        //디버그 출력
//        System.out.println("-----------------");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j].status + " ");
//            }
//            System.out.println();
//        }

        System.out.println(minBridge);

    }
}
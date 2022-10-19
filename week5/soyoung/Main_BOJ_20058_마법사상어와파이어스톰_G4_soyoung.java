import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_20058_마법사상어와파이어스톰_G4 {
    static int N, curSize = 0;
    static Node[][] map;
    static boolean visited[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Node {
        int ice;
        public Node(int ice) {
            super();
            this.ice = ice;
        }
    }

    //시작 인덱스에서 사이즈만큼의 부분배열을 회전시킴
    public static void rotate(int r, int c, int size) {
        //전치행렬
        for (int dy = 0; dy < size; dy++) {
            for (int dx = dy+1; dx < size; dx++) {
                int temp = map[r+dx][c+dy].ice;
                map[r+dx][c+dy].ice = map[r+dy][c+dx].ice;
                map[r+dy][c+dx].ice = temp;
            }
        }

        //좌우반전
        for (int dx = 0; dx < size/2; dx++) {
            for (int dy = 0; dy < size; dy++) {
                int temp = map[r+dy][c+dx].ice;
                map[r+dy][c+dx].ice = map[r+dy][c+size-1-dx].ice;
                map[r+dy][c+size-1-dx].ice = temp;
            }
        }
    }

    public static void fireStorm(int L) {
        //격자 나누기 및 배열 돌리기
        //오른쪽으로 90도 회전: 전치행렬 transpose -> 좌우반전
        int size = (int)Math.pow(2, L);
        int n = N / size;

        for (int i = 0; i < N; i+=size) {
            for (int j = 0; j < N; j+=size) {
                //i, j: 시작인덱스, size에 대하여 배열 돌리기
                rotate(i, j, size);
            }

        }

        //얼음 삭제 노드 기억
        ArrayList<Node> delList = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                //가지치기 1) 현재칸의 얼음이 0이면 탐색 필요 없음
                if(map[r][c].ice == 0) {
                    continue;
                }

                //가지치기 2) 현재칸이 모서리면 탐색 필요 없이 무조건 얼음 삭제
                if((r==0 && c==0) || (r==0 && c==N-1) || (r==N-1 && c==0) || (r==N-1 && c==N-1)) {
                    delList.add(map[r][c]);
                    continue;
                }

                //상하좌우 중 유효하고 얼음이 있는 인접 노드 개수 세기
                int nodes = 0;
                for (int i = 0; i < 4; i++) {
                    int ny = r+dy[i];
                    int nx = c+dx[i];

                    //인덱스 유효성 검사 IndexOutOfBounds
                    if(ny<0 || nx<0 || ny >= N || nx >= N) {
                        continue;
                    }

                    //얼음이 있으면 인접 노드 카운트
                    if(map[ny][nx].ice != 0) {
                        nodes++;
                    }
                }

                //유효하고 얼음이 있는 인접 노드의 개수가 3개 이상이라면 얼음 삭제 노드
                //바로 삭제하면 안됨 (뒤의 칸이 인접 칸을 조사할 때 영향을 미침)
                if(nodes < 3) {
                    delList.add(map[r][c]);
                }
            }
        }

        //얼음 삭제
        for (Node node : delList) {
            node.ice--;
        }
    }


    //dfs 수행하여 함수 call개수만큼 크기 카운트
    public static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int ny = r+dy[i];
            int nx = c+dx[i];

            //IndexOutOfBounds
            if(ny<0 || nx<0 || ny >= N || nx >= N) {
                continue;
            }

            if(map[ny][nx].ice != 0 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                curSize++;
                dfs(ny, nx);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ///////////// 1. input 받기 ////////////
        //N 기반 map 생성 및 초기화
        st = new StringTokenizer(br.readLine());
        N = (int)Math.pow(2, Integer.parseInt(st.nextToken())); //map size: 2^N
        int Q = Integer.parseInt(st.nextToken());
        map = new Node[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
        }

        ///////////// 2. for(Q): 파이어스톰 구현 ////////////
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken()); //격자 크기
            fireStorm(L);
        }


        ///////////// 3. DFS 가장 큰 덩어리 크기 구하기 ////////////
        int ice = 0;
        visited = new boolean[N][N];
        int maxSize = 0; //초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ice += map[i][j].ice;
                if(map[i][j].ice != 0 && !visited[i][j]) {
                    curSize = 1;
                    visited[i][j] = true;
                    dfs(i, j);
                    //더 큰 크기로 갱신
                    maxSize = Math.max(maxSize, curSize);
                }
            }
        }


        ///////////// 4. 결과 출력 ////////////
        System.out.println(ice);
        System.out.println(maxSize);
    }
}
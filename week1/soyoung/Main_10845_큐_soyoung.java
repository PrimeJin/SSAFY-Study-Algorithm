import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 큐 구현
 * 
 */

public class Main_10845_큐_soyoung {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String cmd;
        int n;

        Queue queue = new Queue();

        // for each command
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    n = Integer.parseInt(st.nextToken());
                    queue.push(n);
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
                default:
            }
        }
    }
}

class Queue {
    ArrayList<Integer> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void push(int n) {
        queue.add(n);
    }

    public void pop() {
        if (queue.size() == 0)
            System.out.println(-1);
        else
            System.out.println(queue.remove(0));
    }

    public void size() {
        System.out.println(queue.size());
    }

    public void empty() {
        if (queue.size() == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public void front() {
        if (queue.size() == 0)
            System.out.println(-1);
        else
            System.out.println(queue.get(0));
    }

    public void back() {
        if (queue.size() == 0)
            System.out.println(-1);
        else
            System.out.println(queue.get(queue.size() - 1));
    }

}

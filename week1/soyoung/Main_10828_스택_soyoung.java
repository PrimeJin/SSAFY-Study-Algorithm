import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.omg.Messaging.SyncScopeHelper;

class Stack {
    private ArrayList<Integer> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(int n) {
        stack.add(n);
    }

    public void pop() {
        if (stack.size() == 0)
            System.out.println(-1);
        else
            System.out.println(stack.remove(stack.size() - 1));
    }

    public void size() {
        System.out.println(stack.size());
    }

    public void empty() {
        if (stack.size() == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public void top() {
        if (stack.size() == 0)
            System.out.println(-1);
        else
            System.out.println(stack.get(stack.size() - 1));
    }

}

public class Main_10828_스택_soyoung {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String cmd;
        int n;

        Stack stack = new Stack();

        // for each command
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    n = Integer.parseInt(st.nextToken());
                    stack.push(n);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
                default:
            }
        }

    }
}

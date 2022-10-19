import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1406_에디터_soyoung {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        LinkedList text = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(String.valueOf(str.charAt(i)));
            text.insert(newNode);
        }

        int N = Integer.parseInt(br.readLine());
        Node cursor = text.tail;
        String cmd;
        String c;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            switch (cmd) {
                case "L":
                    if (cursor.prev == text.head)
                        break;
                    cursor = cursor.prev;
                    break;
                case "D":
                    if (cursor == text.tail)
                        break;
                    cursor = cursor.next;
                    break;
                case "B":
                    if (cursor.prev == text.head)
                        break;
                    text.delete(cursor.prev);
                    break;
                case "P":
                    c = st.nextToken();
                    Node newNode = new Node(c);
                    text.insert(newNode, cursor);
                    break;
            }
        }

        cursor = text.head.next;
        while (cursor.next != null) {
            // System.out.print(cursor.str);
            bw.write(cursor.str);
            cursor = cursor.next;
        }
        bw.close();
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    public LinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int size() {
        return this.size;
    }

    public void insert(Node newNode) { // 가장 마지막 노드에 추가
        insert(newNode, this.tail);
    }

    public void insert(Node newNode, Node cursor) { // 특정 노드 왼쪽에 추가
        newNode.next = cursor;
        newNode.prev = cursor.prev;
        cursor.prev.next = newNode;
        cursor.prev = newNode;
        size++;
    }

    public void delete(Node cursor) {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        size--;
    }

}

class Node {
    String str;
    Node prev;
    Node next;

    Node() {
    }

    Node(String str) {
        this.str = str;
    }
}
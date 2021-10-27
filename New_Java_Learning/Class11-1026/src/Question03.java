public class Question03 {
    public static void count(int n){
        int killHead = 3;
        Node head = new Node();
        Node cur = head;
        for(int i = 1;i <= n;i ++){
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        cur.next = head.next;
        Node p = head.next;
        while(p.next != p){
            for(int i = 1; i < killHead - 1; i ++){
                p = p.next;
            }
            System.out.print(p.next.data + "->");
            p.next = p.next.next;
            p = p.next;
        }
        System.out.println("(left:" + p.data + ")");
    }

    public static void main(String[] args) {
        count(30);
    }
}

class Node{
    int data;
    Node next;
    public Node(){
    }
    public Node(int data){
        this.data = data;
    }
}
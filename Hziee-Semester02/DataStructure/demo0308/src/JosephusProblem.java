import java.util.Scanner;

/**
 * @author loukj
 */
public class JosephusProblem {
    public static void main(String[] args) {
        // 输入需要的数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("设置人数：");
        int len = scanner.nextInt();
        System.out.println("开始的位置：");
        int start = scanner.nextInt();
        System.out.println("数多少下：");
        int distance = scanner.nextInt();

        // 创建一个10个人的环形单链表
        Node lastNode = new Node(10);
        Node node9 = new Node(9, lastNode);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node headNode = new Node(1, node2);
        lastNode.next = headNode;

        // 调用下方自定义方法
        josephus(headNode, lastNode, 10, start, distance);
    }

    /**
     * 以下为约瑟夫问题本身的代码
     *
     * @param headNode 第一个节点
     * @param lastNode 最后一个节点
     * @param len      人数
     * @param start    开始的位置
     * @param distance 数多少下
     */
    public static void josephus(Node headNode, Node lastNode, int len, int start, int distance) {
        // 当headNode为null时抛出异常
        if (headNode == null) {
            throw new NullPointerException("headNode为null，headNode = null");
        }
        // 当输入的参数不合法时抛出异常
        if (start < 1 || start > len || distance < 1) {
            throw new IllegalArgumentException("参数不合法");
        }

        // 从start开始报数，headNode同时指向节点
        // 此外，headNode与lastNode还需要往后移动start - 1次
        for (int i = 0; i < start - 1; i++) {
            headNode = headNode.next;
            lastNode = lastNode.next;
        }

        // 此while循环用于执行报数的过程及显示
        // 当人数不为0时执行循环
        while (len != 0) {
            // 执行报数操作，用headNode指向这个节点，找出需要出列的那个孩子
            // 然后headNode与lastNode还需要往后移动distance - 1次
            for (int i = 0; i < distance - 1; i++) {
                headNode = headNode.next;
                lastNode = lastNode.next;
            }
            // 输出编号，也就是headNode的值
            System.out.println(headNode.data);
            // 取得删除节点后的一个节点
            Node nextNode = headNode.next;
            // 设置lastNode的next为nextNode
            lastNode.next = nextNode;
            // 设置headNode的next为null
            headNode.next = null;
            // 人数减少
            len--;
            // 设置headNode指向nextNode
            headNode = nextNode;
        }
    }

    private static class Node {                 //创建节点类
        private final Object data;              //用于保存节点中的数据值
        private Node next;                      //用于保存下一个节点的地址值

        public Node(Object data) {              //初始化data
            this.data = data;
        }

        public Node(Object data, Node next) {   //初始化data和next
            this.data = data;
            this.next = next;
        }
    }
}
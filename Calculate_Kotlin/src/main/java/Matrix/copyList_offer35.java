package Matrix;


import java.util.HashMap;

// https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/submissions/

public class copyList_offer35 {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.next = null;
        node5.random= node1;

        copyRandomList(node1);
    }


    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node,Node> map = new HashMap();

        Node temp = head;
        Node newHead = new Node(head.val);
        Node p = newHead;
        map.put(temp,p);

        while (temp.next != null){
            Node node = new Node(temp.next.val);
            p.next = node;
            p = node;
            temp = temp.next;
            map.put(temp,node);
        }

        temp = head;
        p = newHead;

        while (temp != null){
            Node nodeR = temp.random;
            if (nodeR != null){
                p.random = map.get(nodeR);
            }
            temp = temp.next;
            p = p.next;
        }


        return newHead;

    }
}

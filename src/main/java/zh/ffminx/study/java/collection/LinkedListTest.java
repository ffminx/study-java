package zh.ffminx.study.java.collection;

import java.util.Random;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-18 22:11
 */
public class LinkedListTest {
    
    public Node buildOneWayList(int size) {
        Node head = null;
        Node tmp = null;
        for (int i = 0; i < size; i++) {
            Node node = new Node(new Random().nextInt(100), null);
            if (head == null) {
                head = node;
            }
            if (tmp != null) {
                tmp.setNext(node);
            }
            tmp = node;
        }
        return head;
    }
    
    public void printLinkedList(Node head) {
        System.out.print(head.getValue());
        if (head.getNext() != null) {
            System.out.print("->");
            printLinkedList(head.getNext());
        }
    }
    
    
    public static void main(String[] args) {
        LinkedListTest test = new LinkedListTest();
        Node head = test.buildOneWayList(5);
        test.printLinkedList(head);
    }
    
    
}

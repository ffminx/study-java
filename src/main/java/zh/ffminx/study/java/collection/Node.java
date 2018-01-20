package zh.ffminx.study.java.collection;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2018-01-18 22:09
 */
public class Node {
    
    private int value;
    
    private Node next;
    
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
}

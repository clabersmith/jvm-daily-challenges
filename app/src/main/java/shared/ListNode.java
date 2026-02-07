package shared;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int val) {
        this.value = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }


}
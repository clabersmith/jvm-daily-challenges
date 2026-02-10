package shared;

public class  ListNode<E> {
    E value;
    ListNode<E> next;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public ListNode(E val) {
        this.value = val;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getNext() {
        return next;
    }


}
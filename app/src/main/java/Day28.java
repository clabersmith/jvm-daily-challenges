import shared.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Day28 {

    public static <E> void removeDuplicatesFromLinkedList(ListNode<E> root) {
        usingMemorySavingTime(root);
    }

    private static <E> void usingMemorySavingTime(ListNode<E> head) {
        Set<E> seen = new HashSet<>();
        ListNode<E> currNode = head;
        ListNode<E> prevNode = null;

        System.out.println("starting loop");
        while (currNode != null) {
            System.out.println("in loop");
            if (!seen.add(currNode.getValue())) {
                //remove the current node from the chain as a duplicate
                System.out.println("removing " + currNode.getValue());
                prevNode.setNext(currNode.getNext());
            } else {
                //keep the current node and move the previous node pointer forward
                prevNode = currNode;
            }

            //move the current node pointer forward
            currNode = currNode.getNext();
        }
    }

    private static <E> void usingTimeSavingMemory(ListNode<E> head) {
        ListNode<E> runnerNode = head;

        while (runnerNode != null) {
            //starting from the current pointer in the list
            ListNode<E> currNode = runnerNode.getNext();
            ListNode<E> prevNode = runnerNode;

            while(currNode != null) {
                if(Objects.equals(runnerNode.getValue(), currNode.getValue())) {
                    //remove the currentNode
                    prevNode.setNext(currNode.getNext());
                } else{
                    //keep the current node and move the previous node pointer forward
                    prevNode = currNode;
                }

                currNode = currNode.getNext();
            }

            //move the current node pointer forward
            runnerNode = runnerNode.getNext();
        }
    }

}

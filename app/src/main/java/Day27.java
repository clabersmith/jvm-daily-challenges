import shared.ListNode;

public class Day27 {
    public static boolean hasCycle(ListNode head) {
        //Floyd Tortoise and Hair algorithm for O(1) space, using two pointers
        ListNode slow = head;
        ListNode fast = head;

        //loop while both pointers are inside the linked list
        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();  //move once per iteration
            fast = fast.getNext().getNext();  //move twice

            if(slow == null || fast == null) {
                break;
            }

            //if there is a cycle, fast and slow will enter a loop and eventually meet
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}

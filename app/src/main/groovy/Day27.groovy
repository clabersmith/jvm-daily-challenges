import shared.ListNode

class Day27Groovy {
    static def hasCycle(ListNode head) {
        def slow = head
        def fast = head

        while (fast?.next) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow.is(fast)) return true
        }

        false
    }
}

import shared.ListNode

fun <E> hasCycle(head: ListNode<E>?): Boolean {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) return true
    }

    return false
}

import shared.ListNode

fun <E> removeDuplicatesFromLinkedList(head: ListNode<E>?) {
    val seen = mutableSetOf<E>()
    var curr: ListNode<E>? = head
    var prev: ListNode<E>? = null

    while (curr != null) {
        if (!seen.add(curr.value)) {
            prev?.next = curr.next
        } else {
            prev = curr
        }
        curr = curr.next
    }
}
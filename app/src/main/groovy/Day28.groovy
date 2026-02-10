class Day28Groovy {
    static def removeDuplicatesFromLinkedList(head) {
        def seen = [] as Set
        def curr = head
        def prev = null

        while (curr) {
            if (!seen.add(curr.value)) {
                prev.next = curr.next
            } else {
                prev = curr
            }
            curr = curr.next
        }
    }
}

package support

import shared.ListNode
import shared.TreeNode

class ListNodeHelper {

    static void addStaticBuilders() {
        ListNode.metaClass.static.buildSmallNonCyclic = { -> buildNonCyclic(5) }
        ListNode.metaClass.static.buildLargeNonCyclic = { -> buildNonCyclic(10000) }
        ListNode.metaClass.static.buildSmallCyclic = { -> buildCyclic(5, 2) }
        ListNode.metaClass.static.buildLargeCyclic = { -> buildCyclic(10000, 5000) }
        TreeNode.metaClass.static.buildSkewedRight = { int nodes -> buildSkewedRight(nodes) }
        ListNode.metaClass.static.buildFromList = { List list -> buildFromList(list) }
        ListNode.metaClass.static.convertToList = { ListNode root -> convertToList(root) }
    }

    static ListNode buildNonCyclic(int nodes) {
        if (nodes <= 0) return null
        ListNode head = new ListNode(1)
        ListNode curr = head
        for (int i = 2; i <= nodes; i++) {
            curr.next = new ListNode(i)
            curr = curr.next
        }
        return head
    }

    static ListNode buildCyclic(int nodes, int cyclePos) {
        if (nodes <= 0) return null
        ListNode head = new ListNode(1)
        ListNode curr = head
        ListNode cycleNode = (cyclePos == 1) ? head : null
        for (int i = 2; i <= nodes; i++) {
            curr.next = new ListNode(i)
            curr = curr.next
            if (i == cyclePos) cycleNode = curr
        }
        if (cycleNode != null) curr.next = cycleNode
        return head
    }

    static <E> ListNode<E> buildFromList(List<E> values) {
        if (!values) return null
        ListNode head = new ListNode(values[0])
        ListNode curr = head
        for (int i = 1; i < values.size(); i++) {
            curr.next = new ListNode(values[i])
            curr = curr.next
        }
        return head
    }

    static List convertToList(ListNode head) {
        def out = []
        while (head != null) {
            out << head.getValue()
            head = head.getNext()
        }
        out
    }
}

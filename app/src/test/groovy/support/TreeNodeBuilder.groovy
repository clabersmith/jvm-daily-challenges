package support

import shared.TreeNode

class TreeNodeHelper {
    static void addStaticBuilders() {
        TreeNode.metaClass.static.buildBalanced = { int nodes -> buildBalanced(nodes) }
        TreeNode.metaClass.static.buildSkewedLeft = { int nodes -> buildSkewedLeft(nodes) }
        TreeNode.metaClass.static.buildSkewedRight = { int nodes -> buildSkewedRight(nodes) }
    }

    static TreeNode buildBalanced(int nodes) {
        if (nodes <= 0) return null
        return balanced(1, nodes)
    }

    private static TreeNode balanced(int start, int end) {
        if (start > end) return null
        int mid = (start + end) / 2
        TreeNode node = new TreeNode(mid)
        node.left = balanced(start, mid - 1)
        node.right = balanced(mid + 1, end)
        return node
    }

    static TreeNode buildSkewedLeft(int nodes) {
        if (nodes <= 0) return null
        TreeNode root = new TreeNode(1)
        TreeNode curr = root
        for (int i = 2; i <= nodes; i++) {
            curr.left = new TreeNode(i)
            curr = curr.left
        }
        return root
    }

    static TreeNode buildSkewedRight(int nodes) {
        if (nodes <= 0) return null
        TreeNode root = new TreeNode(1)
        TreeNode curr = root
        for (int i = 2; i <= nodes; i++) {
            curr.right = new TreeNode(i)
            curr = curr.right
        }
        return root
    }
}
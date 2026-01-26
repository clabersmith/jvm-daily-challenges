package support

import shared.TreeNode

class TreeNodeHelper {
    /**
     * This is an example of Groovy's dynamic programming support, as it
     * adds static builder methods to the {@code TreeNode} metaClass so tests can
     * call {@code TreeNode.buildBalanced(...)}, {@code TreeNode.buildSkewedLeft(...)},
     * and {@code TreeNode.buildSkewedRight(...)}.
     */
    static void addStaticBuilders() {
        TreeNode.metaClass.static.buildBalanced = { int nodes -> buildBalanced(nodes) }
        TreeNode.metaClass.static.buildSkewedLeft = { int nodes -> buildSkewedLeft(nodes) }
        TreeNode.metaClass.static.buildSkewedRight = { int nodes -> buildSkewedRight(nodes) }
    }

    /**
     * Builds a balanced binary search tree with node values from 1 to {@code nodes}.
     *
     * @param nodes number of nodes to create; if {@code nodes} &le; 0 returns {@code null}
     * @return root of the balanced tree, or {@code null} when {@code nodes} &le; 0
     */
    static TreeNode buildBalanced(int nodes) {
        if (nodes <= 0) return null
        return balanced(1, nodes)
    }

    /**
     * Recursively builds a balanced subtree for the inclusive range {@code start}..{@code end}.
     *
     * @param start start value for this subtree
     * @param end end value for this subtree
     * @return root node of the subtree, or {@code null} when {@code start} &gt; {@code end}
     */
    private static TreeNode balanced(int start, int end) {
        if (start > end) return null
        int mid = (start + end) / 2
        TreeNode node = new TreeNode(mid)
        node.left = balanced(start, mid - 1)
        node.right = balanced(mid + 1, end)
        return node
    }

    /**
     * Builds a left-skewed tree (every node has only a left child) with values from 1 to {@code nodes}.
     *
     * @param nodes number of nodes to create; if {@code nodes} &le; 0 returns {@code null}
     * @return root of the skewed-left tree, or {@code null} when {@code nodes} &le; 0
     */
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

    /**
     * Builds a right-skewed tree (every node has only a right child) with values from 1 to {@code nodes}.
     *
     * @param nodes number of nodes to create; if {@code nodes} &le; 0 returns {@code null}
     * @return root of the skewed-right tree, or {@code null} when {@code nodes} &le; 0
     */
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
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
        TreeNode.metaClass.static.buildPairOfIdenticalTrees = { int nodes -> buildPairOfIdenticalTrees(nodes) }
        TreeNode.metaClass.static.buildPairOfNonIdenticalTrees = { int nodes -> buildPairOfNonIdenticalTrees(nodes) }
        TreeNode.metaClass.static.prettyPrint = { TreeNode node -> prettyPrint(node) }
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

    /**
     * Returns a Pair (Tuple2) of two structurally identical trees.
     * The first element is a tree built with random structure (balanced, skewed left/right),
     * the second is a deep copy.
     */
    static Tuple2<TreeNode, TreeNode> buildPairOfIdenticalTrees(int nodes) {
        if (nodes <= 0) return new Tuple2<>(null, null)
        int choice = new Random().nextInt(3) // 0 = balanced, 1 = left skewed, 2 = right skewed
        TreeNode first
        switch (choice) {
            case 0:
                first = buildBalanced(nodes)
                break
            case 1:
                first = buildSkewedLeft(nodes)
                break
            default:
                first = buildSkewedRight(nodes)
        }
        TreeNode second = first == null ? null : deepCopy(first)
        return new Tuple2<>(first, second)
    }

    /**
     * Builds a pair of trees that are guaranteed to be non-identical when possible.
     *
     * The first element is created with a random structure (balanced, skewed left, or
     * skewed right). The second element is a deep copy of the first and is then
     * mutated: either a child link is removed (structural change) or a node value is
     * incremented (value change) so the two trees differ. Mutation is chosen
     * pseudo-randomly.
     *
     * If {@code nodes} &le; 0 or either tree is {@code null}, the original pair from
     * {@link #buildPairOfIdenticalTrees(int)} is returned unchanged.
     *
     * @param nodes number of nodes to create for the initial tree
     * @return a {@code Tuple2} containing two trees that differ when possible
     */
    static Tuple2<TreeNode, TreeNode> buildPairOfNonIdenticalTrees(int nodes) {
        Tuple2<TreeNode, TreeNode> pair = buildPairOfIdenticalTrees(nodes)
        TreeNode first = pair.first
        TreeNode second = pair.second
        if (nodes <= 0 || first == null || second == null) return pair

        Random rnd = new Random()

        // collect all nodes in the second tree (pre-order)
        List<TreeNode> nodesList = []
        def traverse
        traverse = { TreeNode n ->
            if (n == null) return
            nodesList << n
            traverse(n.left)
            traverse(n.right)
        }
        traverse(second)

        if (!nodesList.isEmpty()) {
            TreeNode target = nodesList.get(rnd.nextInt(nodesList.size()))

            // Prefer a structural change when possible; otherwise mutate a value
            if ((target.left != null || target.right != null) && rnd.nextBoolean()) {
                if (target.left != null && target.right != null) {
                    if (rnd.nextBoolean()) target.left = null else target.right = null
                } else if (target.left != null) {
                    target.left = null
                } else {
                    target.right = null
                }
            } else {
                // change the integer value to guarantee a difference
                target.value = target.value + 1
            }
        }

        return new Tuple2<>(first, second)
    }

    /**
     * Creates a deep copy of the given tree node and all of its descendants.
     *
     * This performs a recursive traversal and allocates new {@code TreeNode}
     * instances for each node so the returned tree shares no mutable state with
     * the input.
     *
     * @param node root of the subtree to copy; may be {@code null}
     * @return a deep copy of {@code node}, or {@code null} if {@code node} is {@code null}
     */
    private static TreeNode deepCopy(TreeNode node) {
            if (node == null) return null
            TreeNode copy = new TreeNode(node.value)
            copy.left = deepCopy(node.left)
            copy.right = deepCopy(node.right)
            return copy
    }

    /**
     * Builds a "pretty" ASCII representation of a tree, e.g.:
     *
     *        1
     *       / \
     *      2   3
     *     /   / \
     *    4   8   6
     */
    static prettyPrint(TreeNode... nodes) {

        int i = 1
        for (node in nodes) {
            println("** node${i} **")
            if (node == null) {
                println("(empty)")
            } else {
                println(buildTreeLines(node).join("\n"))
            }
            println()
            i++
        }
    }

    private static String[] buildTreeLines(TreeNode node) {
        if (node == null) {
            return new String[0]
        }

        String rootStr = String.valueOf(node.value)
        String[] leftLines = buildTreeLines(node.left)
        String[] rightLines = buildTreeLines(node.right)

        if (leftLines.length == 0 && rightLines.length == 0) {
            return [rootStr] as String[]
        }

        int leftWidth = leftLines.length > 0 ? leftLines[0].length() : 0
        int rightWidth = rightLines.length > 0 ? rightLines[0].length() : 0

        String firstLine = ""
        String secondLine = ""

        if (leftLines.length > 0) {
            int leftRootPos = leftLines[0].indexOf(String.valueOf(node.left.value))
            firstLine += spaces(leftRootPos + 1) + spaces(leftWidth - leftRootPos - 1)
            secondLine += spaces(leftRootPos) + "/" + spaces(leftWidth - leftRootPos - 1)
        }

        firstLine += rootStr
        secondLine += spaces(rootStr.length())

        if (rightLines.length > 0) {
            secondLine += "\\"
        }

        String[] result = new String[2 + Math.max(leftLines.length, rightLines.length)]
        result[0] = firstLine
        result[1] = secondLine

        for (int i = 0; i < Math.max(leftLines.length, rightLines.length); i++) {
            String leftPart = i < leftLines.length ? leftLines[i] : spaces(leftWidth)
            String rightPart = i < rightLines.length ? rightLines[i] : spaces(rightWidth)
            result[i + 2] = leftPart + spaces(rootStr.length()) + rightPart
        }

        result
    }

    private static String spaces(int count) {
        " " * Math.max(0, count)
    }
}
import shared.TreeNode

class Day22Groovy {
    private static final int UNBALANCED = -1

    static boolean isHeightBalanced(TreeNode root) {
        //inline recursive function
        def height
        height = { TreeNode n ->
            if (n == null) return 0

            int lh = height(n.left)
            if (lh == -1) return UNBALANCED

            int rh = height(n.right)
            if (rh == -1) return UNBALANCED

            Math.abs(lh - rh) > 1 ? UNBALANCED : Math.max(lh, rh) + 1
        }

        height(root) >= 0
    }
}

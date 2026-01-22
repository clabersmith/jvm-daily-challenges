import shared.TreeNode;

public class Day22 {
    private static final int UNBALANCED = -1;

    public static boolean isHeightBalanced(TreeNode treeNode) {

        return recursiveGetHeight(treeNode) >= 0;
    }

    private static int recursiveGetHeight(TreeNode treeNode) {
        //null node does not contribute to the height
        if(treeNode == null) {
            return 0;
        }

        int leftHeight = recursiveGetHeight(treeNode.getLeft());
        int rightHeight = recursiveGetHeight(treeNode.getRight());

        //if the tree from the left or right node is unbalanced
        //or if the tree from the current node is, return the UNBALANCED signal
        if(leftHeight == UNBALANCED || rightHeight == UNBALANCED || Math.abs(leftHeight - rightHeight) > 1) {
            return UNBALANCED;
        }

        //otherwise, return the height from the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

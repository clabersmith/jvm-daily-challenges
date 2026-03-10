import shared.TreeNode;

public class Day29 {

    public static boolean isIdenticalStructureAndValue(TreeNode treeNode1, TreeNode treeNode2) {

        //recursive terminal conditions
        if (treeNode1 == null && treeNode2 == null) {
            return true;  //both null, return as identical
        }

        if((treeNode1 == null || treeNode2 == null) ||
            treeNode1.getValue() != treeNode2.getValue()) {
            return false;  //they are unequal
        }

        //the current nodes are equal, so test the child node structure
        return isIdenticalStructureAndValue(treeNode1.getLeft(), treeNode2.getLeft()) &&
                isIdenticalStructureAndValue(treeNode1.getRight(), treeNode2.getRight());
    }
}

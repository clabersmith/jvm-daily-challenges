import shared.TreeNode

class Day29Groovy {
    static def isIdenticalStructureAndValue(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) return true
        if (treeNode1 == null || treeNode2 == null) return false
        if (treeNode1.value != treeNode2.value) return false

        return isIdenticalStructureAndValue(treeNode1.left, treeNode2.left) &&
                isIdenticalStructureAndValue(treeNode1.right, treeNode2.right)
    }
}


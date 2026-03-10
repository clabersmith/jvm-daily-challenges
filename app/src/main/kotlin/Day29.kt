import shared.TreeNode

fun isIdenticalStructureAndValue(treeNode1: TreeNode?, treeNode2: TreeNode?): Boolean = when {
    treeNode1 == null && treeNode2 == null -> true
    treeNode1 == null || treeNode2 == null -> false
    treeNode1.value != treeNode2.value -> false

    else -> isIdenticalStructureAndValue(treeNode1.left, treeNode2.left) &&
            isIdenticalStructureAndValue(treeNode1.right, treeNode2.right)
}


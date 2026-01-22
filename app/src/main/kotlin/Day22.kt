import shared.TreeNode
import kotlin.math.abs

private const val UNBALANCED = -1

fun TreeNode?.isHeightBalanced(): Boolean = this.height() >= 0

//recursive extension function
private fun TreeNode?.height(): Int {
    if (this == null) return 0

    val leftHeight = this.left.height()
    if (leftHeight == UNBALANCED) return UNBALANCED

    val rightHeight = this.right.height()
    if (rightHeight == UNBALANCED) return UNBALANCED

    return if (abs(leftHeight - rightHeight) > 1) UNBALANCED else maxOf(leftHeight, rightHeight) + 1
}
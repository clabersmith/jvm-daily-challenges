import shared.TreeNode
import spock.lang.Specification
import support.TreeNodeHelper

/**
 * Problem:
 * Check if a binary tree is height-balanced.
 *
 * A binary tree is considered height-balanced if, for every node in the tree,
 * the height difference between its left and right subtrees is at most one.
 *
 * The task is to determine whether a given binary tree satisfies this property.
 *
 * Constraints:
 * - The tree may be empty.
 * - The tree may contain only a single node.
 * - The tree may be skewed or fully balanced.
 *
 * Examples:
 * - Input:
 *       1
 *      / \
 *     2   3
 *    /
 *   4
 *   Output: true
 *
 * - Input:
 *       1
 *      /
 *     2
 *    /
 *   3
 *   Output: false
 *
 * - Input: null
 *   Output: true
 */
class Day22Spec extends Specification {
    def setupSpec() {
        TreeNodeHelper.addStaticBuilders()
    }

    void "java: is binary tree height balanced"() {
        expect:
        Day22.isHeightBalanced(tree) == expected

        where:

        tree                                | expected
        null                                | true
        new TreeNode(1)                     | true
        TreeNode.buildBalanced(3)           | true
        TreeNode.buildBalanced(9)           | true
        TreeNode.buildSkewedLeft(3)         | false
        TreeNode.buildSkewedRight(2)        | true    //too few nodes to be unbalanced
        TreeNode.buildSkewedRight(4)        | false
    }

    void "kotlin: is binary tree height balanced"() {
        expect:
        Day22Kt.isHeightBalanced(tree) == expected

        where:

        tree                                | expected
        null                                | true
        new TreeNode(7)                     | true
        TreeNode.buildBalanced(2)           | true
        TreeNode.buildBalanced(4)           | true
        TreeNode.buildSkewedLeft(5)         | false
        TreeNode.buildSkewedRight(12)       | false
    }

    void "groovy: is binary tree height balanced"() {
        expect:
        Day22Groovy.isHeightBalanced(tree) == expected

        where:

        tree                                | expected
        null                                | true
        new TreeNode(42)                    | true
        TreeNode.buildBalanced(5)           | true
        TreeNode.buildBalanced(6)           | true
        TreeNode.buildSkewedLeft(2)         | true  //too few nodes to be unbalanced
        TreeNode.buildSkewedLeft(20)        | false
        TreeNode.buildSkewedRight(5)        | false
    }

}

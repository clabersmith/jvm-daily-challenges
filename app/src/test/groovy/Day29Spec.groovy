import shared.TreeNode
import support.TreeNodeHelper
import spock.lang.Specification

/**
 * Problem: Check whether two binary trees are structurally identical
 *
 * Write a function that determines whether two binary trees are identical in
 * both structure and node values.
 *
 * Two trees are considered identical if:
 * - Both trees are empty, or
 * - The current nodes have the same value, AND
 * - The left subtrees are identical, AND
 * - The right subtrees are identical.
 *
 * The comparison must check structure as well as data — two trees containing
 * the same values in different shapes are NOT identical.
 *
 * Examples
 * --------
 * Tree A:          Tree B:
 *     1                1
 *    / \              / \
 *   2   3            2   3
 *
 * Result: true
 *
 * Tree A:          Tree B:
 *     1                1
 *    /                  \
 *   2                    2
 *
 * Result: false  (different structure)
 *
 * Tree A:          Tree B:
 *     1                1
 *    / \              / \
 *   2   3            2   4
 *
 * Result: false  (different values)
 */
class Day29Spec extends Specification {

    def setupSpec() {
        TreeNodeHelper.addStaticBuilders()
    }

    def "is binary tree identical structure and values"() {
        // uncomment to view tree node structures
        //  setup:
        //  println("test for nodeCount: $nodeCount")
        //  TreeNodeHelper.prettyPrint(tree1 as TreeNode, tree2 as TreeNode)

        expect:
        impl(tree1 as TreeNode, tree2 as TreeNode) == expected

        where:
        [implName, impl, nodeCount, builder, expected] << [implementations(), identicalTreeData()].combinations().collect { impl, data ->
            [impl[0], impl[1], data[0], data[1], data[2]]
        }

        // derived values from the chosen builder
        treePair = builder(nodeCount)
        tree1 = treePair[0]
        tree2 = treePair[1]
    }

    def "is binary tree not identical structure and values"() {
        // uncomment to view tree node structures
        //  setup:
        //  println("test for nodeCount: $nodeCount")
        //  TreeNodeHelper.prettyPrint(tree1 as TreeNode, tree2 as TreeNode)

        expect:
        impl(tree1 as TreeNode, tree2 as TreeNode) == expected

        where:
        [implName, impl, nodeCount, builder, expected] << [implementations(), nonIdenticalTreeData()].combinations().collect { impl, data ->
            [impl[0], impl[1], data[0], data[1], data[2]]
        }

        // derived values from the chosen builder
        treePair = builder(nodeCount)
        tree1 = treePair[0]
        tree2 = treePair[1]
    }

    private static List<List> implementations() {
        [
                ["Java", { t1, t2 -> Day29.isIdenticalStructureAndValue(t1, t2) }],
                ["Kotlin", { t1, t2 -> Day29Kt.isIdenticalStructureAndValue(t1, t2) }],
                ["Groovy", { t1, t2 -> Day29Groovy.isIdenticalStructureAndValue(t1, t2) }]
        ]
    }

    private static List<List> identicalTreeData() {
        [
                [0, { TreeNode.buildPairOfIdenticalTrees(it) }, true],
                [1, { TreeNode.buildPairOfIdenticalTrees(it) }, true],
                [3, { TreeNode.buildPairOfIdenticalTrees(it) }, true],
                [9, { TreeNode.buildPairOfIdenticalTrees(it) }, true],
                [13, { TreeNode.buildPairOfIdenticalTrees(it) }, true]
        ]
    }

    private static List<List> nonIdenticalTreeData() {
        [
                [3, { TreeNode.buildPairOfNonIdenticalTrees(it) }, false],
                [4, { TreeNode.buildPairOfNonIdenticalTrees(it) }, false],
                [5, { TreeNode.buildPairOfNonIdenticalTrees(it) }, false],
                [7, { TreeNode.buildPairOfNonIdenticalTrees(it) }, false],
                [9, { TreeNode.buildPairOfNonIdenticalTrees(it) }, false],
                [15, { TreeNode.buildPairOfNonIdenticalTrees(it) }, false]
        ]
    }


}

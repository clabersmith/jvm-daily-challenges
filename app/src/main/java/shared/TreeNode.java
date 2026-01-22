package shared;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {}

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        setLeft(left);
        setRight(right);
    }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public TreeNode getLeft() { return left; }
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() { return right; }
    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode node = (TreeNode) o;
        return value == node.value;
    }

    @Override
    public int hashCode() { return Integer.hashCode(value); }

    @Override
    public String toString() { return Integer.toString(value); }
}
public class TestMyBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createTree(); // ***初始化根节点

        // 判断是否是完全二叉树
        boolean isComplete = tree.isCompleteTree();
        System.out.println("Is the tree complete? " + isComplete);
    }
}

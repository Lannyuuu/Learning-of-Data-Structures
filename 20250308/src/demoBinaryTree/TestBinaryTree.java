package demoBinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree myBinaryTree = new BinaryTree();
        BinaryTree.TreeNode root = myBinaryTree.createTree();
        myBinaryTree.preOrder(root);
        System.out.println();
        myBinaryTree.postOrder(root);
        System.out.println();
        myBinaryTree.middleOrder(root);

        System.out.println();
        myBinaryTree.size(root);
        System.out.println(myBinaryTree.nodeSize);
        myBinaryTree.getLeafNode(root);
        System.out.println(myBinaryTree.leafCount);
    }
}

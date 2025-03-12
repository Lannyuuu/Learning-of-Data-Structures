package BinaryTree;

public class Test {
    public static void main(String[] args) {
        //求二叉树第K层的节点个数
        BinaryTree myBinaryTree = new BinaryTree();
        //定义一个根节点（实例化）
        BinaryTree.TreeNode root = myBinaryTree.createTree();
        System.out.print("第2层的节点个数：");
        System.out.println(myBinaryTree.getLevelNodeCount(root, 2));
        System.out.println("二叉树的深度是："+myBinaryTree.TreeHeight(root));
        System.out.println(myBinaryTree.find(root, 'U'));
    }
}

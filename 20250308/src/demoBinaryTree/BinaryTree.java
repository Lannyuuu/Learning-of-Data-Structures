package demoBinaryTree;

import com.sun.source.tree.Tree;

//二叉树

public class BinaryTree {
    class TreeNode{
        //孩子表示法
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    //创建根节点
    private TreeNode root;

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        //E.right = H;
        return A;
    }
    //前序遍历
    public void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);//递归
        preOrder(root.right);
    }
    //中序遍历
    public void middleOrder(TreeNode root){
        if (root == null) return;
        middleOrder(root.left);//递归
        System.out.print(root.val + " ");
        middleOrder(root.right);
    }
    //后序遍历
    public void postOrder(TreeNode root){
        if (root == null)return;
        //左 右 根
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public int nodeSize = 0;
    // 获取树中节点的个数
    public void size(TreeNode root){
        if (root == null) return;
        nodeSize ++;
        size(root.left);
        size(root.right);
    }
    public int leafCount;
    //获取叶子结点的个数
    public void getLeafNode(TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null){
            leafCount++;
        }
        getLeafNode(root.left);
        getLeafNode(root.right);
    }
}


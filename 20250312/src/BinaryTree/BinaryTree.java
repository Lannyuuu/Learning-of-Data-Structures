package BinaryTree;
import java.util.*;
//二叉树：递归实现
//函数名：testTree()
//在计算目标值之后，递归左子树和右子树
//testTree(root.left);
//testTree(root.right);

public class BinaryTree {
    //创建树节点
    class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode root;
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
        E.right = H;
        return A;
    }
    //前序遍历:根-左-右
    public void preOrder(TreeNode root){
        if(root == null) return;
        System.out.println(root.val + " "); //根
        preOrder(root.left); //左
        preOrder(root.right); //右
    }
    //中序遍历:左-根-右
    public void middleOrder(TreeNode root){
        if (root == null) return;
        middleOrder(root.left);
        System.out.println(root.val + " ");
        middleOrder(root.right);
    }
    //后序遍历：左-右-根
    public void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }
    //public int nodeSize = 0;
    //计算节点个数：定义一个节点个数变量，++后递归左子树和右子树
    public void size(TreeNode root){
        int nodeSize = 0;
        if (root == null) return;
        nodeSize++;
        size(root.left);
        size(root.right);
    }
    //获取叶子节点个数
    public void leafNodeSize(TreeNode root){
        int leafcount = 0;
        if (root == null) return;
        if (root.left == null && root.right == null){
            leafcount++;
        }
        leafNodeSize(root.left);
        leafNodeSize(root.right);
    }
    //新学的：
    //获取第K层的节点个数
    public int getLevelNodeCount(TreeNode root, int k){
        if (root == null) return 0;
        if (k == 1) return 1;
        return getLevelNodeCount(root.left,k-1)+
                getLevelNodeCount(root.right,k-1);
        //每次递归调用时，k 的值减 1，表示向下一层推进。
    }
    //二叉树的高度
    //最高的可能在左边也有可能在右边：
    //分别求左子树的高度和右子树的高度：
    //整体的高度 = max(左子树高度，右子树高度) + 1
    public int TreeHeight(TreeNode root){
        if (root == null) return 0;
        int leftHeight = TreeHeight(root.left);
        int rightHeight = TreeHeight(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
    public TreeNode find(TreeNode root,char key){
        if (root == null) return null;
        if (root.val == key){
            return root;
        }
        TreeNode leftresult = find(root.left,key);
        if (leftresult != null) return leftresult;
        TreeNode rightresult = find(root.right,key);
        if(rightresult != null) return rightresult;
        return null;
    }
}

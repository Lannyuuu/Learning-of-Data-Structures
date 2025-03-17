package BinaryTree;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    public TreeNode root;
    //判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //相同：值相同，结构相同
        //要判断整棵树相同，先判断根节点，左子树相同，右子树相同
        //情况1：根都是null：true
        //情况2：根不都是null，有null：false
        //情况3：两个根节点的值不同：flase
        if ( p == null && q == null) return true;
        if ( p == null || q == null) return false;
        if ( p.val != q.val ) return false;
        //递归实现的是根节点的转移
        //左子树相同 && 右子树相同
        return isSameTree(p.left,q.left) && isSameTree( p.right,q.right);
        //算时间复杂度：
        //p:n个节点，q:m个节点--O(min(m,n))
    }
    //两个二叉树root subRoot，检验root中是否包含和subRoot具有相同结构的节点值的字数
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //是子树：1.和该树相同2.和该树子树相同
        //遍历每一个节点：相同，判断左子树是不是相同，判断右子树是不是相同
        //用isSameTree函数判断
        //入股遍历出现null了，一定是false
        if (root == null || subRoot == null) return false;
        //判断根节点是不是相同
        if (isSameTree(root,subRoot)){
            return true;
        }
        //root树遍历每一个节点（作为新的根节点）
        if (isSubtree(root.left,subRoot)){
            return true;
        }else if(isSubtree(root.right,subRoot)){
            return true;
        }else{
            return false;
        }
    }
    //反转二叉树:左右进行反转
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = root.left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //复习：计算二叉树的高度:左子树高度和右子树高度最大值
    //求高度的时间复杂度：O(n)
    public int TreeHeight(TreeNode root){
        if (root == null) return 0;
        int leftHeight = TreeHeight(root.left);
        int rightHeight = TreeHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1; //注意这里+1：要把根节点算进去
    }
    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        //高度平衡二叉树，每棵子树的高度差不能大于1
        if (root == null) return true;
        int leftHeight = TreeHeight(root.left);
        int rightHeight = TreeHeight(root.right);

        return Math.abs( leftHeight-rightHeight ) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return isSymmetricChile(root.left,root.right);
    }
    //判断树是不是对称的
    public boolean isSymmetricChile(TreeNode leftTree, TreeNode rightTree) {
        //判断root的左子树和右子树是不是对称的
        //对称：
        //1.根节点结构相同
        //2.根节点值相同
        //3.左子树的左子树和右子树的右子树对称且左子树的右子树和右子树的左子树对称
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;

        if (leftTree.val != rightTree.val) return false;
        return isSymmetricChile(leftTree.left,rightTree.right)
                && isSymmetricChile(leftTree.right,rightTree.left);
    }
}

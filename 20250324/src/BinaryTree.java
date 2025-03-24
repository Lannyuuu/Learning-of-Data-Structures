import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
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

    // 判断是不是完全二叉树
    public boolean isCompleteTree() {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 层序遍历，直到遇到第一个null节点
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }

        // 检查队列中剩余的节点是否都为null
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }

        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q){
        //从根节点开始找
        if (root == null) return null; //存在递归，一定要有base:root == null
        //1.判断p/q是不是根节点
        if (p == root || q == root) return root;
        //2.去左子树找
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        //3.去右子树找
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);

        if (leftTree != null && rightTree != null){
            return root;
        }else if(leftTree != null){
            return leftTree;
        }else{
            return rightTree;
        }
    }

}

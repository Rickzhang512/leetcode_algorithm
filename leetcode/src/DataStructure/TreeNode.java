package DataStructure;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int item) {
        this.value = item;
        this.left = this.right = null;
    }

    TreeNode root;

    // 构造函数初始化空的二叉树
    public TreeNode() {
        root = null;
    }




    // 插入方法
    public TreeNode insert(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = insert(current.left, value);
        } else if (value > current.value) {
            current.right = insert(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    // 调用插入方法的辅助函数
    public void add(int value) {
        root = insert(root, value);
    }

    // 中序遍历
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    // 其他遍历方法（前序、后序）可以类似地定义...

    // 查找值是否存在于树中
    public boolean containsNode(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNode(current.left, value)
                : containsNode(current.right, value);
    }

    // 查找值的辅助方法
    public boolean find(int value) {
        return containsNode(root, value);
    }


    int diameter = 0;//二叉树的直径 https://leetcode.cn/problems/diameter-of-binary-tree/
    public int countDiameter(TreeNode root){
        if(root==null) return 0;
        int left = countDiameter(root.left);
        int right = countDiameter(root.right);
        diameter = Math.max(diameter,left + right);
        return Math.max(left,right)+1;

    }

    int levelOfBinaryTree = 0;//二叉树的层数
    public int countLevel(TreeNode root){
        if(root==null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);

        return Math.max(left,right)+1;

    }


    public static void main(String[] args) {

            TreeNode bt = new TreeNode(7);

            // 添加节点
            bt.add(6);
            bt.add(4);
            bt.add(8);
            bt.add(3);
            bt.add(5);
            bt.add(7);
            bt.add(9);

            // 中序遍历打印
            bt.inorderTraversal(bt.root);

    }


}

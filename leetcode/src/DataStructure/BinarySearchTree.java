package DataStructure;

public class BinarySearchTree {
    TreeNode root = null;

    BinarySearchTree() {
    }

    void insert(int value) {
        this.root = this.insertRec(this.root, value);
    }

    TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        } else {
            if (value < root.value) {
                root.left = this.insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = this.insertRec(root.right, value);
            }

            return root;
        }
    }

    void search(int value) {
        this.root = this.searchRec(this.root, value);
    }

    TreeNode searchRec(TreeNode root, int value) {
        if (root != null && root.value != value) {
            return root.value < value ? this.searchRec(root.right, value) : this.searchRec(root.left, value);
        } else {
            return root;
        }
    }

    void inorder() {
        this.inorderRec(this.root);
    }

    void inorderRec(TreeNode root) {
        if (root != null) {
            this.inorderRec(root.left);
            System.out.println(root.value);
            this.inorderRec(root.right);
        }

    }

    public static int searchMax(TreeNode root, int val) {
        if (root == null) {
            return -1;
        } else if (root.value <= val) {
            int right = searchMax(root.right, val);
            return right != -1 ? right : root.value;
        } else {
            return searchMax(root.left, val);
        }
    }

    public static int searchMin(TreeNode root, int val) {
        if (root == null) {
            return -1;
        } else if (root.value >= val) {
            int left = searchMin(root.left, val);
            return left != -1 ? left : root.value;
        } else {
            return searchMin(root.right, val);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(2);
        bst.insert(4);
        bst.insert(9);
        bst.insert(13);
        bst.insert(1);
        bst.insert(4);
        bst.insert(9);
        bst.insert(15);
        TreeNode result = bst.searchRec(bst.root, 9);
        if (result != null) {
            System.out.println("Found: " + result.value);
        } else {
            System.out.println("Not Found");
        }

        bst.inorder();
    }
}

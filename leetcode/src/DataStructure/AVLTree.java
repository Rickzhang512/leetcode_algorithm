package DataStructure;

public class AVLTree {
    class AVLNode {
        int val;
        int height;
        AVLNode left, right;

        public AVLNode(int d) {
            val = d;
            height = 1;
        }
    }

    AVLNode root;

    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    AVLNode insert(AVLNode node, int val) {
        if (node == null)
            return (new AVLNode(val));

        if (val < node.val)
            node.left = insert(node.left, val);
        else if (val > node.val)
            node.right = insert(node.right, val);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && val < node.left.val)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && val > node.right.val)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // The main function that inserts a new key in the AVL tree
    public void insert(int val) {
        root = insert(root, val);
    }
}

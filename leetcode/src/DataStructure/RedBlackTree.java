package DataStructure;

class RedBlackTree {
    TreeNode root;
    TreeNode NIL;

    public RedBlackTree() {
        TreeNode nilNode = new TreeNode(0);
        nilNode.color = Color.Black;
        this.NIL = nilNode;
        this.root = this.NIL;
    }

    public void leftRotate(TreeNode x) {
        TreeNode y = x.right;
        x.right = y.left;
        if(y.left != this.NIL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == this.NIL) { //x is root
            this.root = y;
        }
        else if(x == x.parent.left) { //x is left child
            x.parent.left = y;
        }
        else { //x is right child
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(TreeNode x) {
        TreeNode y = x.left;
        x.left = y.right;
        if(y.right != this.NIL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == this.NIL) { //x is root
            this.root = y;
        }
        else if(x == x.parent.right) { //x is left child
            x.parent.right = y;
        }
        else { //x is right child
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    //handle after the insertion of violation of red-black tree properties
    public void insertFixup(TreeNode z) {
        /*Case 1: The parent node and uncle node of the current node are both red.

        Case 2: The parent node of the current node is red, the uncle node is black, and the current node is the right child node (left rotation is required).

        Case 3: The parent node of the current node is red, the uncle node is black, and the current node is the left child node (right rotation is required)
        */
        while(z.parent.color == Color.Red) {
            if(z.parent == z.parent.parent.left) { //z.parent is the left child

                TreeNode y = z.parent.parent.right; //uncle of z

                if(y.color == Color.Red) { //case 1
                    z.parent.color = Color.Black; //parent set to black
                    y.color = Color.Black; //uncle node set to black
                    z.parent.parent.color = Color.Red;// grandparent node change to red
                    z = z.parent.parent; //operation node to grandparent
                }
                else { //case2 or case3
                    if(z == z.parent.right) { //case2 the current node is the right child node
                        z = z.parent; //marked z.parent as new z
                        leftRotate(z);
                    }
                    //case3
                    z.parent.color = Color.Black; //made parent black
                    z.parent.parent.color = Color.Red; //made parent red
                    rightRotate(z.parent.parent);
                }
            }
            else { //z.parent is the right child
                TreeNode y = z.parent.parent.left; //uncle of z

                if(y.color == Color.Red) {//case1
                    z.parent.color = Color.Black;
                    y.color = Color.Black;
                    z.parent.parent.color = Color.Red;
                    z = z.parent.parent;
                }
                else {
                    if(z == z.parent.left) {//case3
                        z = z.parent; //marked z.parent as new z
                        rightRotate(z);
                    }
                    z.parent.color = Color.Black; //made parent black
                    z.parent.parent.color = Color.Red; //made parent red
                    leftRotate(z.parent.parent);
                }
            }
        }
        this.root.color = Color.Black;
    }

    public void insert(TreeNode z) {
        TreeNode y = this.NIL; //variable for the parent of the added node
        TreeNode temp = this.root;

        while(temp != this.NIL) {
            y = temp;
            if(z.value < temp.value)
                temp = temp.left;
            else
                temp = temp.right;
        }
        z.parent = y;

        if(y == this.NIL) { //newly added node is root
            this.root = z;
        }
        else if(z.value < y.value) //data of child is less than its parent, left child
            y.left = z;
        else
            y.right = z;

        z.right = this.NIL;
        z.left = this.NIL;

        insertFixup(z);
    }

    public void inorder(TreeNode n) {
        if(n != this.NIL) {
            inorder(n.left);
            System.out.println(n.value);
            inorder(n.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();

        TreeNode a, b, c, d, e, f, g, h, i, j, k, l, m;
        a = new TreeNode(10);
        b = new TreeNode(20);
        c = new TreeNode(30);
        d = new TreeNode(100);
        e = new TreeNode(90);
        f = new TreeNode(40);
        g = new TreeNode(50);
        h = new TreeNode(60);
        i = new TreeNode(70);
        j = new TreeNode(80);
        k = new TreeNode(150);
        l = new TreeNode(110);
        m = new TreeNode(120);

        t.insert(a);
        t.insert(b);
        t.insert(c);
        t.insert(d);
        t.insert(e);
        t.insert(f);
        t.insert(g);
        t.insert(h);
        t.insert(i);
        t.insert(j);
        t.insert(k);
        t.insert(l);
        t.insert(m);

        t.inorder(t.root);
    }
}
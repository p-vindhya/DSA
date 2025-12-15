package Tree;

public class AVL {
    public class Node {
        private int value;
        private Node right;
        private Node left;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public AVL() {

    }

    public int height() {
        return height(root);
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    public void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, " Left node of " + node.value + " ");
        display(node.right, " Right node of " + node.value + " ");
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;

        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {

                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {

                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node node) {
        Node c = node.left;
        Node t = c.right;
        c.right = node;
        node.left = t;
        node.height = Math.max(height(node.left), height(node.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;
        return c;

    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;
        c.left = p;
        p.right = t;
        p.height = Math.max(height(p.left), height(p.right))+ 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;

    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

public void prettyDisplay(){
prettyDisplay(this.root,0);
}

private void prettyDisplay(Node node,int level){
    if(node==null){
        return;
    }
    prettyDisplay(node.right,level+1);
    if(level!=0){
        for(int i=0;i<level-1;i++){
            System.out.print("|\t\t");
        }
        System.out.println("|------------>"+node.value);
    }
    else{
        System.out.println(node.value);
    }
     prettyDisplay(node.left,level+1);
}

    public static void main(String[] args) {
        AVL avl = new AVL();
        for(int i=1;i<1000;i++){
            avl.insert(i);
        }
        avl.display();
        System.out.println("The height of avl tree is "+avl.height());
        avl.prettyDisplay();

    

}}

package Tree;

public class BST {
    public class Node{
      private  int value;
      private  Node right;
      private  Node left;
      private  int height;
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;
    public BST(){

    }
public int height(){
    return height(root);
}

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void display(){
        display(root,"Root Node: ");
    }

    public void display(Node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left," Left node of "+node.value+" ");
         display(node.right," Right node of "+node.value+" ");
    }

    public void insert(int value){
        root=insert(value,root);
    }

    public Node insert(int value,Node node){
        if(node==null){
           node=new Node(value);
           return node;

        }
        if(value<node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    public boolean balanced(){
       return balanced(root);
    }

    public boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right) )<=1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node==null){
            return ;
        }

        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null){
            return ;
        }
        
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node==null){
            return ;
        }
        
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }

public static void main(String[] args) {
    BST bst=new BST();
    int [] nums={5,2,7,1,4,6,9,8,3,10};
    bst.populate(nums);
    bst.display();
    System.out.println(bst.balanced());
    System.out.println("Height of tree is : "+bst.height());
    bst.preOrder();
    System.out.println();
    bst.inOrder();
     System.out.println();
    bst.postOrder();
}

}

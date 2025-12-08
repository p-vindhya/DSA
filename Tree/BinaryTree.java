package Tree;

import java.util.Scanner;

public class BinaryTree {
    public class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root node value: ");
        int value=scanner.nextInt();
        root=new Node(value);
        populate(scanner, root);

    }
    public void populate(Scanner scanner,Node root){
        System.out.println("Do you want to have left node for "+root.val+" ");
        Boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of left node to "+root.val+" :");
            int leftValue=scanner.nextInt();
            root.left=new Node(leftValue);
            populate(scanner, root.left);
        }
         System.out.println("Do you want to have right node for "+root.val+" ");
       
        Boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of right node to "+root.val+" :");
            int rightValue=scanner.nextInt();
            root.right=new Node(rightValue);
            populate(scanner, root.right);
        }

    }

    public void display(){
        display(this.root,"");
    }
    private void display(Node root,String indent){
        if(root==null){
            return;
        }
        System.out.println(indent+root.val);
        display(root.left,indent+"\t");
          display(root.right,indent+"\t");
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
        System.out.println("|------------>"+node.val);
    }
    else{
        System.out.println(node.val);
    }
     prettyDisplay(node.left,level+1);
}

public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    BinaryTree binaryTree=new BinaryTree();
    binaryTree.populate(scanner);
    binaryTree.prettyDisplay();

}

}

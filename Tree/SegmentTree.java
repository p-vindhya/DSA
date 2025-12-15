package Tree;

public class SegmentTree {

    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int startInterval;
        private int endInterval;
        public Node(int startInterval,int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }
    private Node root;

    public void insert(int []arr){
      this.root=  insert(arr,0,arr.length-1);
    }
    private Node insert(int[] arr,int start,int end){
        if(start==end){
            Node node=new Node(start,end);
            node.value=arr[start];
            return node;
        }
        int mid=start+(end-start)/2;
        Node node=new Node( start, end);
        node.left=insert(arr, start, mid);
        node.right=insert(arr, mid+1, end);
        node.value=node.left.value+node.right.value;
        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node){

        if(node==null){
            return;
        }
        if(node.left!=null){
            System.out.println("Interval ["+node.left.startInterval+","+node.left.endInterval+"] has value "+node.left.value+" Left child of Interval ["+node.startInterval+","+node.endInterval+"]");
        }
        else{
            System.out.println("Interval ["+node.startInterval+","+node.endInterval+"] has no Left child");
        }

        System.out.println("Interval ["+node.startInterval+","+node.endInterval+"] has value "+node.value);

        if(node.right!=null){
            System.out.println("Interval ["+node.right.startInterval+","+node.right.endInterval+"] has value "+node.right.value+" Right child of Interval ["+node.startInterval+","+node.endInterval+"]");
        }
        else{
            System.out.println("Interval ["+node.startInterval+","+node.endInterval+"] has no Right child");
        }
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }

    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11};
        SegmentTree segmentTree=new SegmentTree();
        segmentTree.insert(arr);
        segmentTree.display();
    
}}

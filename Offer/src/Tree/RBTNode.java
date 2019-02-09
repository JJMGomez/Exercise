package Tree;

public class RBTNode extends TreeNode{
    public static final boolean RED = false;//将RED，BLACK定义为常量
    public static final boolean BLACK = true;

    private int data;
    RBTNode leftTree;
    RBTNode rightTree;
    RBTNode parent;
    boolean color;



    RBTNode(){
        super();
        this.parent = null;
        this.color = RED;
    }
    RBTNode(int data, RBTNode left, RBTNode right, boolean color, RBTNode parent){
        this.color = color;
        this.data = data;
        this.leftTree = left;
        this.rightTree = right;
        this.parent = parent;
    }



}

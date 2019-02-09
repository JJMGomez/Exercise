package Tree;


public class TreeNode {

    private int data;
    TreeNode leftTree;
    TreeNode rightTree;

    public TreeNode() {
        this.data = 0;
        this.leftTree = null;
        this.rightTree = null;

    }

    public TreeNode(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }

}


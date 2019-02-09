package Tree;

import Tree.BSTree;
import Tree.TreeNode;



public class RBTree extends BSTree {
    private RBTNode root;

    public static final boolean RED = false;//将RED，BLACK定义为常量
    public static final boolean BLACK = true;

    private void leftRotate(RBTNode x){ //红黑树左旋
        RBTNode y = x.rightTree;
        x.rightTree = y.leftTree;
        if(y.leftTree != null){
            y.leftTree.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        }
        else if (x == x.parent.leftTree){
            x.parent.leftTree = y;
        }
        else{
            x.parent.rightTree = y;
        }
    }
    private void rightRotate(RBTNode y){//红黑树右旋
        RBTNode x = y.leftTree;
        y.leftTree = x.rightTree;
        if (x.rightTree != null){
            x.rightTree.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null){
            this.root = x;
        }
        else if (y == y.parent.leftTree){
            y.parent.leftTree = x;
        }
        else{
            y.parent.rightTree = x;
        }
    }

    // 红黑树节点插入，这个也太复杂惹...
    // 首先，我们需要将节点插入二叉树中，并着色为红
    public void Insert(RBTNode z){
        if (root == null){
            root = z;
        }
        RBTNode current = root;
        RBTNode y = null;
        while(current != null){ //找到目标位置
            y = current;
            if (current.getData() > z.getData()){
                current = current.leftTree;
            }
            else{
                current = current.rightTree;
            }
        }
        z.parent = y;
        if (y == null){
            root = z;
        }
        else if (z.getData()>y.getData()){
            y.rightTree = z;
        }
        else{
            y.leftTree = z;
        }
        z.leftTree = null;
        z.rightTree = null;
        z.color = RED;
        insertFixup(root, z);

    }

    public void insertFixup(RBTNode root, RBTNode z){

    }

}

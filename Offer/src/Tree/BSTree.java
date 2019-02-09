package Tree;

public class BSTree {
    private TreeNode root;

    public boolean Insert(int data){
        TreeNode node = new TreeNode(data);

        if (root==null){
            root = node;
            return true;
        }
        else {
            TreeNode current = root;
            TreeNode buffer = null;
            while (true) {
                buffer = current;
                if (root.getData() < data) {
                    current = current.rightTree;
                    if (current == null){
                        buffer.rightTree = node;
                        return true;

                    }
                }
                else{
                    current = current.leftTree;
                    if(current == null){
                        buffer.leftTree= node;
                        return true;

                    }
                }
            }
        }
    }
    public TreeNode Contain(int data){
        TreeNode current = root;
        while(true){
            if(current== null){
                return null;
            }
            else{
                if(current.getData()==data){
                   return current;
                }
                else if(current.getData()>data){
                        current = current.leftTree;
                    }
                else{
                        current = current.rightTree;
                    }
                }
            }
        }
    public void preOrder(TreeNode root){
        if (root != null) {
            preOrder(root.leftTree);
            System.out.print(root.getData()+" ");
            preOrder((root.rightTree));
        }
    }

    public void inOrder(TreeNode root){
        if (root != null) {
            System.out.print(root.getData()+" ");
            preOrder(root.leftTree);
            preOrder((root.rightTree));
        }
    }

    public void postOrder(TreeNode root){
        if (root != null) {
            preOrder(root.leftTree);
            preOrder((root.rightTree));
            System.out.print(root.getData() + " ");
        }
    }
    public static void main(String[] args){
        BSTree tree_1 = new BSTree();
        tree_1.Insert(23);
        tree_1.Insert(45);
        tree_1.Insert(11);
        System.out.print(tree_1.Contain(45));
        System.out.println(" ");
        tree_1.preOrder(tree_1.root);
        System.out.println(" ");
        tree_1.inOrder(tree_1.root);
        System.out.println(" ");
        tree_1.postOrder(tree_1.root);
    }
}

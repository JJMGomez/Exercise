package medium;
/**
 * Leetcode 2385
 * date：2024/1/10
 * */
public class AmountOfTimeTreeInfected {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    private static int maxDistance = 0;

    public static int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return maxDistance;
    }

    private static int traverse(TreeNode root, int start) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int leftDepth = traverse(root.left, start);
        int rightDepth = traverse(root.right, start);

        if (root.val == start) {
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }

        return depth;
    }

    public static int amountOfTime1(TreeNode root, int start) {
          if (root == null){
              return 0;
          }
          int left = 0;
          int right = 0;
          int leftDepth = 0;
          int rightDepth = 0;
          if (root.left != null){
              left = level(root.left,start);
              leftDepth = calculateDepth(root.left);
          }
          if (root.right != null){
              right = level(root.right,start);
              rightDepth = calculateDepth(root.right);
          }

         if (left == 0){
             return Math.max(rightDepth-right, right +leftDepth);
         }
         else{
             return Math.max(leftDepth-left,rightDepth+left);
         }

    }

    public static int level(TreeNode root, int start){
          if (root == null){
              return 0;
          }
          if (start == root.val){
              return 1;
          }
          int left = level(root.left,start);
          int right = level(root.right,start);
          if (left == 0 && right ==0){
              return 0;
          }
          return left + right + 1;
    }
    public static int calculateDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.right = node5;
        System.out.print(amountOfTime(node1,4));
    }
}

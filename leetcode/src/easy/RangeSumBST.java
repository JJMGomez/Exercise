package easy;

/**
 * Leetcode 938
 * date：2024/1/7
 * */
public class RangeSumBST {
    public class TreeNode {
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        int cur = root.val > low && root.val < high ? root.val : 0;
        int leftSum = rangeSumBST(root.left,low,high);
        int rightSum = rangeSumBST(root.right,low,high);
        return cur + leftSum + rightSum;
    }
}

package interviewBit.dynamicProgramming;

public class MaximumSumPath {
	
	int max = Integer.MIN_VALUE;
	
	static class TreeNode{
		int val;
		TreeNode left, right;
		
		public TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}
	
	public int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);
		
		int maxSumPath = Math.max(root.val, root.val + Math.max(left,right));
		
		max = Math.max(Math.max(max,maxSumPath) , root.val + left + right);

        return maxSumPath;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-100);
		root.left = new TreeNode(-200);
		root.left.left = new TreeNode(-300);
		root.left.right = new TreeNode(-400);
		
		MaximumSumPath obj = new MaximumSumPath();
		
		obj.maxPathSum(root);
		System.out.println(obj.max);
	}

}
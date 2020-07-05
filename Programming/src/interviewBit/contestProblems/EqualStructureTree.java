package interviewBit.contestProblems;

public class EqualStructureTree {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
	}

	public int countEqual(TreeNode A, TreeNode B) {
		if (A == null && B == null) {
			return 0;
		} else if (A != null && B != null) {
			if((A.left == null && A.right != null && (B.left != null && B.right != null)))
				return Integer.MIN_VALUE;
			else if((B.left == null && B.right != null && (A.left != null && A.right != null)))
				return Integer.MIN_VALUE;
			else
				return countEqual(A.left, B.left) + countEqual(A.right, B.right);
		} else if (A == null && B != null) {
			return countEqual(null, B.left) + countEqual(null, B.right) + 1;
		} else if (A != null && B == null) {
			return countEqual(null, A.left) + countEqual(null, A.right) + 1;
		}
		return 0;
	}

	public int cntMatrix(TreeNode A, TreeNode B) {
		int res = countEqual(A, B);
		if (res < 0)
			return -1;
		return res;
	}

	public static void main(String[] args) {
		EqualStructureTree obj = new EqualStructureTree();
		TreeNode A = new TreeNode(10);
		/*
		 * A.left = new TreeNode(9); A.right = new TreeNode(20);
		 */
		
		TreeNode B = new TreeNode(5);
		//B.left = new TreeNode(2);
		B.right = new TreeNode(7);
		//B.left.left = new TreeNode(1);
		B.right.left = new TreeNode(7);
		B.right.right = new TreeNode(7);
		int res = obj.cntMatrix(A, B);
		System.out.println(res);
	}

}
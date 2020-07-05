package interviewBit.dynamicProgramming;

public class RectangleSum {
	public int solve(int[][] mat) {
		int n = mat.length, m = mat[0].length;
		int[][] rowPrefix = new int[n][m];

		for (int i = 0; i < n; ++i) {
			rowPrefix[i][0] = mat[i][0];
			for (int j = 1; j < m; ++j) {
				rowPrefix[i][j] = rowPrefix[i][j-1] + mat[i][j];
			}
		}

		int maxSoFar = Integer.MIN_VALUE;
		for (int j = 0; j < m; ++j) {
			for (int k = j+1; k < m; ++k) {
				int max = 0;
				for (int i = 0; i < n; ++i) {
					max += rowPrefix[i][k] - rowPrefix[i][j] + mat[i][j];
					maxSoFar = Math.max(max, maxSoFar);
					max = Math.max(0, max);
				}
			}
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		int[][] arr = {
						  {-1, -1, -1},
						  {-1, -1, -1},
						  {-1, -1, -1},
						};
		RectangleSum obj = new RectangleSum();
		System.out.println(obj.solve(arr));
	}
}
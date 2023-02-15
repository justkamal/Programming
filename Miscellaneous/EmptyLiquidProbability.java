public class EmptyLiquidProbability {

    public static void main(String[] args) {
        EmptyLiquidProbability mainObj = new EmptyLiquidProbability();
        System.out.printf("%.5f", mainObj.solve(100));
    }

    public double solve(int n) {
        return computeForFirstEmpty(n, n) + (0.5 * computeForEmptyAtSame(n, n));
    }

    public double computeForFirstEmpty(int l1, int l2) {
        if (l1 <= 0 && l2 > 0) {
            return 1;
        } else if (l2 <= 0) {
            return 0;
        } else {
            return    0.25 * computeForFirstEmpty(l1 - 25, l2 - 75)
                    + 0.25 * computeForFirstEmpty(l1 - 75, l2 - 25)
                    + 0.25 * computeForFirstEmpty(l1 - 100, l2)
                    + 0.25 * computeForFirstEmpty(l1 - 50, l2 - 50);
        }
    }

    public double computeForEmptyAtSame(int l1, int l2) {
        if (l1 <= 0 && l2 <= 0) {
            return 1;
        } else if ((l2 <= 0 && l1 > 0) || (l1 <= 0 && l2 > 0)) {
            return 0;
        } else {
            return    0.25 * computeForEmptyAtSame(l1 - 25, l2 - 75)
                    + 0.25 * computeForEmptyAtSame(l1 - 75, l2 - 25)
                    + 0.25 * computeForEmptyAtSame(l1 - 100, l2)
                    + 0.25 * computeForEmptyAtSame(l1 - 50, l2 - 50);
        }
    }
}

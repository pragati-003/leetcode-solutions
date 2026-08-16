class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find maximum element in this column
            int maxRow = 0;

            for (int row = 0; row < n; row++) {
                if (mat[row][mid] > mat[maxRow][mid]) {
                    maxRow = row;
                }
            }

            // Current maximum element
            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : -1;

            // Peak found
            if (mat[maxRow][mid] > left &&
                mat[maxRow][mid] > right) {

                return new int[]{maxRow, mid};
            }

            // Move towards larger neighbor
            if (left > mat[maxRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
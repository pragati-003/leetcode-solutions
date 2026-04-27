class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // 1. Left -> Right
            for (int j = left; j <= right; j++) {
                mat[top][j] = num++;
            }
            top++;

            // 2. Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num++;
            }
            right--;

            // 3. Right -> Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    mat[bottom][j] = num++;
                }
                bottom--;
            }

            // 4. Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = num++;
                }
                left++;
            }
        }

        return mat;
    }
}
class Solution {
    public int countSquares(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int count = 0;

        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                if(i != 0 && j != 0 && mat[i][j] == 1){
                    mat[i][j] += Math.min(mat[i-1][j], Math.min(mat[i][j-1], mat[i-1][j-1]));
                }
                count += mat[i][j];
            }
        }
        return count;
    }
}
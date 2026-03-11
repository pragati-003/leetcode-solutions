class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0;i<n;i++){
            for(int j = i;j<m;j++){
                swap(mat, i, j);
            }
        }

        for(int i = 0;i<n;i++){
            reverse(mat, i);
        }
    }

    public void swap(int[][] m , int i , int j){
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
    }

    public void reverse(int[][] m, int row){
    int left = 0;
    int right = m.length - 1;

    while(left < right){
        int temp = m[row][left];
        m[row][left] = m[row][right];
        m[row][right] = temp;
        left++;
        right--;
        }
    }
}
class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i<n ;i++){
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueen(board,0,ans);
        return ans.size();
    }

    private void nqueen(char[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if(row == n){
            //copy 2D char Array into list of String
            List<String> l = new ArrayList<>();
            for(int i = 0; i < n;i++){
                String str = "";
                for(int j = 0;j < n;j++){
                    str += board[i][j];
                }
                l.add(str);
            }
            ans.add(l);
            return;
        }
        for (int j = 0; j < n; j++) { // work and call
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nqueen(board,row+1, ans);  // recursion
                board[row][j] = '.';  //backtracking
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // column
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') return false;
        }

        // upper left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        // upper right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++) {
           if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}
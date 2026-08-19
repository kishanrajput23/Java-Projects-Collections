class Solution
{
public:
    // make vectors of boards-
    //  check with and w/o that element
    //  check left diag up, down, left col

    bool isPossible(int row, int col, vector<string> board, int n)
    {
        // queens don't fall in the same place
        int drow = row, dcol = col;
        while (row >= 0 && col >= 0)
        {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = drow;
        col = dcol;
        while (col >= 0)
        {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        col = dcol;
        while (row < n && col >= 0)
        {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    void solve(int col, vector<string> &board, vector<vector<string>> &ans, int n)
    {

        if (col == n)
        {
            ans.push_back(board);
            return;
        }

        for (int row = 0; row < n; row++)
        {
            if (isPossible(row, col, board, n))
            {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    vector<vector<string>> solveNQueens(int n)
    {

        vector<vector<string>> ans;

        vector<string> board(n);
        string s(n, '.');

        for (int i = 0; i < n; i++)
        {
            board[i] = s;
        }

        solve(0, board, ans, n);

        return ans;
    }
};
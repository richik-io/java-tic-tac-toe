public class Backend {
    private char[][] board;
    private char currentPlayer;

    public Backend() {
        board = new char[3][3];
        currentPlayer = 'X';
    }

    public boolean placeMark(int row, int col) {
        if (board[row][col] == '\0') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkForWin() {
        // check rows for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        // check columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '\0' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        // check diagonals for a win
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}

public class BoardFactory {

    public static Tile[][] createBoardFromChars(char[][] boardAsChars) {
        // TODO: 2019-09-09 Add validation
        int numberOfRows = boardAsChars.length;
        int numberOfCols = boardAsChars[0].length;
        Tile[][] board = new Tile[numberOfRows][numberOfCols];

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {
                char currentChar = boardAsChars[i][j];
                if (currentChar == 'P') {
                    board[i][j] = new Tile(GameObject.PACMAN);
                }
                else if (currentChar == ' ') {
                    board[i][j] = new Tile(GameObject.EMPTY);
                }
            }
        }
        return board;
    }
}

public class BoardFactory {

    public static Board createBoardFromChars(char[][] boardAsChars) {
        // TODO: 2019-09-09 Add validation
        int numberOfRows = boardAsChars.length;
        int numberOfCols = boardAsChars[0].length;
        Tile[][] tiles = new Tile[numberOfRows][numberOfCols];

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfCols; j++) {
                char currentChar = boardAsChars[i][j];
                if (currentChar == 'P') {
                    tiles[i][j] = new Tile(GameObject.PACMAN, false);
                }
                else if (currentChar == ' ') {
                    tiles[i][j] = new Tile(GameObject.EMPTY, false);
                }
                else if (currentChar == '.') {
                    tiles[i][j] = new Tile(GameObject.EMPTY, true);
                }
                else if (currentChar == 'W') {
                    tiles[i][j] = new Tile(GameObject.WALL, false);
                }
                else if (currentChar == 'M') {
                    tiles[i][j] = new Tile(GameObject.MONSTER, true);
                }
            }
        }
        return new Board(tiles);
    }

    public static Board initialiseBoard() {
        char[] row1 = {'.', '.', '.'};
        char[] row2 = {'W', 'P', '.'};
        char[] row3 = {'.', '.', 'M'};
        char[][] boardAsChar = {row1, row2, row3};
        return createBoardFromChars(boardAsChar);
    }
}

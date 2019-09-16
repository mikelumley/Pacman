import java.util.ArrayList;

public class Board {
    private Tile[][] tiles;
    private int numberOfRows;
    private int numberOfCols;

    public Board(Tile[][] tiles) {
        this.tiles = tiles;
        this.numberOfRows = tiles.length;
        this.numberOfCols = tiles[0].length;
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public int getNumberOfRows() {
        return this.numberOfRows;
    }

    public int getNumberOfCols() {
        return this.numberOfCols;
    }

    public Position findPacman() {
        for(int i = 0; i < this.tiles.length; i++) {
            for(int j = 0; j < this.tiles[0].length; j++) {
                Tile tile = this.tiles[i][j];
                if (tile.getObjectOnTile() == GameObject.PACMAN) {
                    return new Position(i, j);
                }
            }
        }
        throw new RuntimeException("Error: Pacman doesn't exist");
    }

    public ArrayList<Position> findMonsters() {
        ArrayList<Position> monsterPositions = new ArrayList<>();

        for(int i = 0; i < this.tiles.length; i++) {
            for(int j = 0; j < this.tiles[0].length; j++) {
                Tile tile = this.tiles[i][j];
                if (tile.getObjectOnTile() == GameObject.MONSTER) {
                    monsterPositions.add(new Position(i, j));
                }
            }
        }
        return monsterPositions;
    }

    public int calculateScore() {
        int score = 0;

        for(int i = 0; i < this.tiles.length; i++) {
            for(int j = 0; j < this.tiles[0].length; j++) {
                if (this.tiles[i][j].getObjectOnTile() == GameObject.EMPTY && !this.tiles[i][j].hasFood())
                    score++;
            }
        }
        return score;
    }

    public void moveGameObject(GameObject gameObject, Position currentPosition, Position nextPosition) {
        if (this.tiles[nextPosition.getX()][nextPosition.getY()].getObjectOnTile() != GameObject.WALL) {
            this.tiles[currentPosition.getX()][currentPosition.getY()].setObjectOnTile(GameObject.EMPTY);
            this.tiles[nextPosition.getX()][nextPosition.getY()].setObjectOnTile(gameObject);
            if (gameObject == GameObject.PACMAN)
                this.tiles[currentPosition.getX()][currentPosition.getY()].setFoodOnTile(false);
        }
    }

}

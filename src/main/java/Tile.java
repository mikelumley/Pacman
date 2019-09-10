public class Tile {

    private GameObject objectOnTile;

    public Tile(GameObject objectOnTile) {
        this.objectOnTile = objectOnTile;
    }

    public GameObject getObjectOnTile() {
        return this.objectOnTile;
    }

    public void setObjectOnTile(GameObject objectOnTile) {
        this.objectOnTile = objectOnTile;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tile tile = (Tile) obj;
        return objectOnTile == tile.objectOnTile;
    }
}

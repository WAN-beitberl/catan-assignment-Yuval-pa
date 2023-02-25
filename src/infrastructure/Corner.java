package infrastructure;


import main.PlayerManager;

import static infrastructure.BuildingType.*;

/**
 * A class used to represent the corners of the board
 */
public class Corner {


    private BuildingType status;
    private final Location location;
    private int playerId;
    private final Path[] edges;
    private int numOfEdges;
    private final Tile[] tiles;
    private int numOfTiles;

    public Corner(Location location){
        status =EMPTY;
        this.location = location;
        playerId = -1;
        numOfTiles =0;
        numOfEdges =0;
        edges = new Path[3];
        tiles = new Tile[3];
        addTiles();
    }

    public BuildingType getStatus(){return status;}
    public Location getLocation(){return this.location;}
    public int getPlayerID(){return this.playerId;}
    public Path[] getEdges(){return this.edges;}

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getNumOfTiles() {
        return numOfTiles;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * build a settlement in this corner, if it's empty and not blocked
     * @param playerId the id of the player how build the settlement
     * @return true if the build was successful else false
     */
    public boolean build(int playerId){
        if (status!=EMPTY || this.playerId!=-1){
            return false;
        }
        this.status= SETTLEMENT;
        this.playerId = playerId;
        return true;
    }

    public void produce(int type) {
        if (this.status == SETTLEMENT ||this.status == CITY)
            PlayerManager.getInstance(this.playerId).produce(type,status);
    }

    /**
     * adds all the tiles that are next to the corner to the tile array of the corner
     */
    private void addTiles(){
        // the base location of the tile is in the upper rows of the board
        if (this.location.get_xCor() <6)
            findTilesIfCornerIsInUpperPartOfTheBoard();
        else
            findTilesForCornerInLowerPartOfTheBoard();
    }

    public boolean upgrade(int playerID){
        if(this.status != SETTLEMENT || this.playerId != playerID) return false;
        this.status = CITY;
        return true;
    }

    public boolean addEdge(Path edge){
        if (numOfEdges<3) {
            edges[numOfEdges] = edge;
            numOfEdges++;
            setToBlock();
            return true;
        }
        return false;
    }

    private void findTilesIfCornerIsInUpperPartOfTheBoard(){
        var xLoc = this.location.get_xCor();
        var yLoc = this.location.get_yCor();

        if (xLoc%2!=0){
            // lower tile
            if (xLoc==5){
                addTileToArray(new Location(xLoc+3, yLoc));
            }
            else
                addTileToArray(new Location(xLoc +3, yLoc+1));

            //right
            addTileToArray(new Location(xLoc+1, yLoc+1));
            // left
            addTileToArray(new Location(xLoc+1,yLoc));
        }

        else{
            // upper tile
            addTileToArray(new Location(xLoc,yLoc));
            //left tile
            addTileToArray(new Location(xLoc +2, yLoc -1));
            //right tile
            addTileToArray(new Location(xLoc +2, yLoc));
        }
    }
    private void findTilesForCornerInLowerPartOfTheBoard(){
        var xLoc = this.location.get_xCor();
        var yLoc = this.location.get_yCor();

        if (xLoc%2!=0){
            //lower tile
            addTileToArray(new Location(xLoc+3, yLoc -1));
            //left
            addTileToArray(new Location(xLoc +1,yLoc -1));
            //right
            addTileToArray(new Location(xLoc +1, yLoc));
        }
        else{
            //upper tile
            addTileToArray(new Location(xLoc,yLoc));
            //left
            addTileToArray(new Location(xLoc+2,yLoc-1));
            //right
            addTileToArray(new Location(xLoc + 2,yLoc));
        }
    }

    private void addTileToArray(Location location){
        if (CornerManager.checkIfLocationIsLegal(location) && TileManager.checkIfTileExist(location)) {
            var tile = TileManager.getInstance(location);
            this.tiles[this.numOfTiles] = tile;
            numOfTiles++;
            tile.addSettlement(this);
        }
    }

    // todo write test
    private void setToBlock(){
        if (status!=BuildingType.EMPTY && numOfEdges<2)
            return;
        if (numOfEdges == 2&& edges[0].getPlayerId() == edges[1].getPlayerId()){
            this.status = BuildingType.BLOCKED;
        }
        else if (numOfEdges == 3){
            if(edges[0].getPlayerId() == edges[2].getPlayerId() ||
                    edges[1].getPlayerId() == edges[2].getPlayerId()){
                this.status = BLOCKED;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Corner corner = (Corner) o;

        return location.equals(corner.location);
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }
}

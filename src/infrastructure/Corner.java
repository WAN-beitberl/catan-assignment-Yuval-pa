package infrastructure;


import main.PlayerManager;

import static infrastructure.BuildingType.*;

/**
 * A class used to represent the corners of the board
 */
public class Corner {


    private BuildingType status;
    private Location location;
    private int playerId;
    private Path[] edges;
    private int numOfEdges;
    private Tile[] tiles;
    private int numOfTiles;

    public Corner(Location location){
        status =EMPTY;
        this.location = location;
        playerId = -1;
        numOfTiles =0;
        numOfEdges =0;
        edges = new Path[3];
        tiles = new Tile[3];
        // todo add all the tiles of this location
    }

    public BuildingType getStatus(){return status;}
    public Location getLocation(){return this.location;}
    public int getPlayerID(){return this.playerId;}
    public Path[] getEdges(){return this.edges;}

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

    private void addTiles(){
        // todo write this function
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

    private void addTile(Tile tile){
        this.tiles[this.numOfTiles] = tile;
        numOfTiles++;
        tile.addSettlement(this);
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

    public boolean upgrade(int playerID){
        if(this.status != SETTLEMENT || this.playerId != playerID) return false;
        this.status = CITY;
        return true;
    }

    public void produce(int type) {
        if (this.status == SETTLEMENT ||this.status == CITY)
            PlayerManager.getInstance(this.playerId).produce(type,status);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    /**
     * test if two settlements are the same
     * @param o a settlement type to test
     * @return true if the two have the same values, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;

        Corner that = (Corner) o;

        return (this.location.equals(that.location));
    }
}

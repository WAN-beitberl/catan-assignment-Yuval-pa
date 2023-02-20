package infrastructure;


import main.PlayerManager;

/**
 * A class used to represent the corners of the board
 */
public class Corner extends Building {
   public static final int EMPTY = 0;
   public static final int BLOCKED = 1;
   public static final int SETTLEMENT = 2;
   public static final int CITY = 3;

    private int status;
    private Location location;

    public Corner(Location location){
        super();
        this.status = EMPTY;
        this.location = location;
        // todo add all the tiles of this location
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
        if (!super.equals(o)) return false;

        Corner that = (Corner) o;

        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + status;
        return result;
    }

    public boolean isEmpty(){return (this.status == EMPTY);}
    public boolean isBlocked(){return (this.status == BLOCKED);}
    public boolean isSettlement(){return (this.status == SETTLEMENT);}
    public boolean isCity(){return (this.status == CITY);}
    public Location getLocation(){return this.location;}

    /**
     * build a settlement in this corner, if it's empty and not blocked
     * @param playerId the id of the player how build the settlement
     * @return true if the build was successful else false
     */
    public boolean build(int playerId){
        this.status= SETTLEMENT;
        this.playerId = playerId;
        return true;
    }

    /**
     * declarer this corner as blocked
     * @return true if the operation was successful else false
     */
    public boolean setToBlock(){
        if (this.status != EMPTY)
            return false;
        this.status = BLOCKED;
        return true;
    }

    /**
     * upgrade the settlement to a city if it is not one already
     */
    public void upgrade(){
        if (this.status == SETTLEMENT){
            this.status = CITY;
            System.out.println("Congrats the settlement is now a city");
        }
        else{
            System.out.println("You can not upgrade a city");
        }
    }

    public void produce(int type) {
        if (this.status == SETTLEMENT ||this.status == CITY)
            PlayerManager.getInstance(this.playerId).produce(type,status);
    }
}

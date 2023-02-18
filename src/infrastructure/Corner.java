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

    /**
     * the status of the corner
     */
    private int status;
    public Corner(Location location){
        super(location);
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

    public int getStatus(){ return this.status;}

    public boolean build(){
        if(this.status != EMPTY)
            return false;
        this.status= SETTLEMENT;
        return true;
    }

    public boolean setToBlock(){
        if (this.status != EMPTY)
            return false;
        this.status = BLOCKED;
        return true;
    }
    // upgrade the settlement to a city if it is not one
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

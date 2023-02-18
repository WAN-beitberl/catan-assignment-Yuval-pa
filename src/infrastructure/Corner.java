package infrastructure;


/**
 * A class used to represent the corners of the board
 */
public class Corner extends Building {
   private final int EMPTY = 0;
   private final int BLOCKED = 1;
   private final int SETTLEMENT = 2;
   private final int CITY = 3;

    /**
     * the status of the corner
     */
    private int status;
    public Corner(int xCor, int yCor, String color){
        super(xCor, yCor, color);
        this.status =EMPTY;
    }
    public Corner(int xCor, int yCor, String color, int playerId) {
        super(xCor, yCor, color,playerId);
        this.status = EMPTY;
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

    // upgrade the settlement to a city if it is not one
    public void upgrade(){
        if (this.status == 0){
            this.status = 1;
            System.out.println("Congrats the settlement is now a city");
        }
        else{
            System.out.println("You can not upgrade a city");
        }
    }

    /*public void produce(int type) {

    }*/
}

package infrastructure;

 import java.util.Objects;

public abstract class Building {
    protected Location pos; // todo: delete after merge
    protected String playerColor;// todo: delete after merge
    protected int playerId;
    protected boolean isVisible;

    //TODO: make it possible to make a building with no Location data and add it later
    public Building(int xCor, int yCor, String color){
        this.pos = new Location(xCor, yCor);
        this.playerColor=color;
        this.isVisible = false;
        this.playerId = 0;
    }
    // todo: delete after merge, keep to not write all tests from zero
    public Building(int xCor, int yCor, String playerColor, int playerId){
        this(xCor, yCor,playerColor);
        this.playerId= playerId;
    }

    /**
     * @return an int[] with the first index holding the x-axis and the second index the y-axis
     */
    public int[] getLocation(){
        int []loc = new int[2];
        loc[0]=this.pos.get_xCor();
        loc[1]=this.pos.get_yCor();
        return loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;
        Building building = (Building) o;
        return pos.equals(building.pos) && playerColor.equals(building.playerColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, playerColor);
    }

}

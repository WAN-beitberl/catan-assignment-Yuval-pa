package infrastructure;

public abstract class Building {
    protected Location pos;
    protected String playerColor;

    //TODO: make it possible to make a building with no Location data and add it later
    public Building(int xCor, int yCor, String color){
        this.pos = new Location(xCor, yCor);
        this.playerColor=color;
    }

    /**
     * @return an int[] with the first index holding the x-axis and the second index the y-axis
     */
    public int[] getLocation(){
        int []loc = new int[2];
        loc[0]=this.pos.getxCor();
        loc[1]=this.pos.getyCor();
        return loc;
    }

    public abstract boolean equals(Building building);
}

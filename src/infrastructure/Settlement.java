package infrastructure;

public class Settlement extends Building {
    private int level; // level 0 - settlement/ level 1 - city
    public Settlement(int xCor, int yCor, String color) {
        super(xCor, yCor, color);
        this.level = 0;
    }

    /**
     * test if two settlements are the same
     * @param building a settlement type to test
     * @return true if the two have the same values, else false.
     */
    @Override
    public boolean equals(Building building) {
        if (building.getClass() == Settlement.class)
            if (this.pos.equals(building.pos))
                if (this.level == ((Settlement) building).level)
                    return this.playerColor.equals(building.playerColor);

        return false;
    }

    public int getLevel(){ return this.level;}

    // upgrade the settlement to a city if it is not one
    public void upgrade(){
        if (this.level == 0){
            this.level = 1;
            System.out.println("Congrats the settlement is now a city");
        }
        else{
            System.out.println("You can not upgrade a city");
        }
    }
}

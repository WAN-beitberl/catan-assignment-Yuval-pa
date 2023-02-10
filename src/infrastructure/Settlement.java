package infrastructure;

public class Settlement extends Building {
    private int level; // level 0 - settlement/ level 1 - city
    public Settlement(int xCor, int yCor, String color) {
        super(xCor, yCor, color);
        this.level = 0;
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

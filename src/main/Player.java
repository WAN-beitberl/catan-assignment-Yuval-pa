package main;


public class Player {
    private final String name;
    private final String color;
    private int numOfWinPoints;
    public Player(String name, String color)
    {
        this.name = name;
        this.color =color;
        this.numOfWinPoints = 2;
    }
    public String getName(){ return this.name;}
    public String getColor(){return this.color;}

    public int getNumOfWinPoints() {
        return numOfWinPoints;
    }

    public boolean incrementNumberOfWinPoints(int byHowMuch){
        if(byHowMuch <3&& byHowMuch>0){
            this.numOfWinPoints+=byHowMuch;
            return true;
        }

        System.out.println("Error illegal increment number");
        return false;
    }
}

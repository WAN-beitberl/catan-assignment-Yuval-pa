package main;


import infrastructure.Path;
import infrastructure.Settlement;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String name;
    private final String color;
    private int numOfWinPoints;
    private ArrayList<Settlement> settlements;
    private ArrayList<Path> paths;

    public Player(String name, String color)
    {
        this.name = name;
        this.color =color;
        this.numOfWinPoints = 0;
        this.settlements =new ArrayList<>();
        this.paths = new ArrayList<>();
    }
    public String getName(){ return this.name;}
    public String getColor(){return this.color;}

    public ArrayList<Settlement> getSettlements() {
        return settlements;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public int getNumOfWinPoints() {
        return numOfWinPoints;
    }

    /**
     * add a new settlement to the player with no duplicates using user input.
     */
    public void addSettlement(){
        Scanner scanner = new Scanner(System.in);
        int xCor, yCor;

        System.out.println("Enter X location");
        xCor = scanner.nextInt();
        System.out.println("Enter Y location");
        yCor = scanner.nextInt();
        Settlement settlement = new Settlement(xCor,yCor, this.color);

       if (!this.settlements.contains(settlement)){
            this.settlements.add(settlement);
            this.numOfWinPoints++;
        }
    }

    /**
     * add a new settlement to the player with no duplicates using parameters.
     * @param xCor the X-axis of the settlement
     * @param yCor the Y-axis of the settlement
     */
    public void addSettlement(int xCor, int yCor){
        Settlement settlement = new Settlement(xCor,yCor, this.color);
        if (!this.settlements.contains(settlement)){
            this.settlements.add(new Settlement(xCor,yCor,this.color));
            this.numOfWinPoints++;
        }
    }
}

package main;


import infrastructure.CornerManager;
import infrastructure.Location;
import infrastructure.Path;
import infrastructure.Corner;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static final int  DESERT= 0;
    public static final int  WOOD= 1;
    public static final int  WOOL= 2;
    public static final int  STONE= 3;
    public static final int  CLAY= 4;
    public static final int  WHEAT= 5;

    private String name;
    private String color;
    private int playerId;
    private int numOfWinPoints;
    private int [] resources;
    private ArrayList<Corner> settlements;
    private ArrayList<Path> paths;

    public Player(int playerId){
        this.playerId = playerId;
        inputNameAndColor();
        this.numOfWinPoints = 0;
        this.settlements = new ArrayList<>();
        this.paths = new ArrayList<>();
        this.resources = new int[6];
    }

    private void inputNameAndColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("player: "+ this.playerId+" please enter your name");
        this.name=scanner.next();
        System.out.println("Hi"+this.name+" please enter your color");
        this.color = scanner.next();
    }

    // todo delete this constructor
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
    public ArrayList<Corner> getSettlements() {return settlements;}
    public ArrayList<Path> getPaths() {
        return paths;
    }
    public int getNumOfWinPoints() {return numOfWinPoints;}
    public int getPlayerId(){return this.playerId;}
    public int[] getResources(){return this.resources;}
    public int getResource(int type){return this.resources[type];}

    // todo finish the function
    public boolean build(String building, Location location){
        if (!canBuild(building) || !CornerManager.checkIfLocationIsLegal(location))
            return false;
        var corner = CornerManager.getInstance(location);

        switch (building.toLowerCase())
        {
            case("settlement"):
            {
                if (corner.isEmpty() || (corner.isBlocked() && this.playerId == corner.getPlayerId())){
                    corner.build(this.playerId);
                }
            }
        }
    }

    /**
     * get resources from settlements beside producing tiles.
     * @param type the type of resource to add to the player
     * @param status the type of the settlements.
     * @see Corner#produce(int)
     * @see infrastructure.Tile#produce(int)
     */
    public void produce(int type, int status){
        if(type == DESERT)
            return;
        int amountToAdd;
        if (status == Corner.SETTLEMENT)
            amountToAdd = 1;
        else
            amountToAdd = 2;
        this.resources[status] +=amountToAdd;
    }

    /**
     * Checks if the player can build a given building type
     * @param buildingType the name of the building type to check
     * @return true if the player has enough resources to build the building, else false
     */
    public boolean canBuild(String buildingType){
        if (buildingType.equalsIgnoreCase("settlement")) {
            return (getResource(CLAY) >= 1 && getResource(WOOD) >= 1 && getResource(WOOL) >= 1 && getResource(WHEAT) >= 1);
        }
        else if(buildingType.equalsIgnoreCase("city")){
            return (getResource(STONE) >=3 && getResource(WHEAT) >=2);
        }
        else if (buildingType.equalsIgnoreCase("path")){
            return (getResource(CLAY) >=1 && getResource(WOOD) >=1);
        }
        return false;
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
        Corner corner = new Corner(new Location(xCor, yCor));

       if (!this.settlements.contains(corner)){
            this.settlements.add(corner);
            this.numOfWinPoints++;
        }
    }

    /**
     * add a new settlement to the player with no duplicates using parameters.
     * @param xCor the X-axis of the settlement
     * @param yCor the Y-axis of the settlement
     */
    public void addSettlement(int xCor, int yCor){
        Corner corner = new Corner(new Location(xCor, yCor));
        if (!this.settlements.contains(corner)){
            this.settlements.add(corner);
            this.numOfWinPoints++;
        }
    }

    // todo add a method that checks if the player can place a settlement in a certain spot

    public boolean addPath(Corner goingFrom){
        // Todo add an option to check if there is no path of another player

        int[] location = new int[4];
        if(this.settlements.contains(goingFrom)){
            var temp = goingFrom.getLocation();
            location[0] = temp.get_xCor();
            location[1] = temp.get_yCor();

            Scanner scanner = new Scanner(System.in);
            System.out.println("enter x location of where the path should go");
            location[2] = scanner.nextInt();
            System.out.println("enter y location of where the path should go");
            location[3] = scanner.nextInt();

            var path = new Path(location, this.color);
            if(!this.paths.contains(path)){
                this.paths.add(path);
                return true;
            }
            else
            {
                System.out.println("error the path already exists");
                return false;
            }
        }

        System.out.println("you can only build a path from your settlement");
        return false;
    }

    /**
     * adds a new path of the user with no duplicities
     * @param goingFrom a path must come
     * @param xTo the x location of where the path should go
     * @param yTo the y location of where the path should go
     * @return true if the path was added successfully else false
     */
    public boolean addPath(Corner goingFrom, int xTo, int yTo){
        // Todo add an option to check if there is no path of another player
        // todo add an option to make a path going from another path of the user
        int[] location = new int[4];
        if(this.settlements.contains(goingFrom)){
            var temp = goingFrom.getLocation();
            location[0] = temp.get_xCor();
            location[1] = temp.get_yCor();
            location[2] = xTo;
            location[3] = yTo;

            var path = new Path(location, this.color);
            if(!this.paths.contains(path)){
                this.paths.add(path);
                return true;
            }
            else
            {
                System.out.println("error the path already exists");
                return false;
            }
        }

        System.out.println("you can only build a path from your settlement");
        return false;
    }

}

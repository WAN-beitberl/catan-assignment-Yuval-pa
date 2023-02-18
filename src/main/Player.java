package main;


import infrastructure.Location;
import infrastructure.Path;
import infrastructure.Corner;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private String color;
    private int playerId;
    private int numOfWinPoints;
    private ArrayList<Corner> settlements;
    private ArrayList<Path> paths;

    public Player(int playerId){
        inputNameAndColor();
        this.numOfWinPoints = 0;
        this.playerId = playerId;
        this.settlements = new ArrayList<>();
        this.paths = new ArrayList<>();
    }

    private void inputNameAndColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your name");
        this.name=scanner.next();
        System.out.println("please enter your color");
        this.color = scanner.next();
    }

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

    public ArrayList<Corner> getSettlements() {
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

package main;


import infrastructure.*;

import java.util.ArrayList;
import java.util.Scanner;

import static infrastructure.BuildingType.EMPTY;
import static infrastructure.BuildingType.SETTLEMENT;


public class Player {
    public static final int DESERT = 0;
    public static final int WOOD = 1;
    public static final int WOOL = 2;
    public static final int STONE = 3;
    public static final int CLAY = 4;
    public static final int WHEAT = 5;

    private String name;
    private String color;
    private int playerId;
    private int numOfWinPoints;
    private int[] resources;
    private ArrayList<Corner> settlements;
    private ArrayList<Path> paths;

    public Player(int playerId) {
        this.playerId = playerId;
        inputNameAndColor();
        this.numOfWinPoints = 0;
        this.settlements = new ArrayList<>();
        this.paths = new ArrayList<>();
        this.resources = new int[6];
    }

    private void inputNameAndColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("player: " + this.playerId + " please enter your name");
        this.name = scanner.next();
        System.out.println("Hi" + this.name + " please enter your color");
        this.color = scanner.next();
    }

    // todo delete this constructor
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.numOfWinPoints = 0;
        this.settlements = new ArrayList<>();
        this.paths = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public ArrayList<Corner> getSettlements() {
        return settlements;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public int getNumOfWinPoints() {
        return numOfWinPoints;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public int[] getResources() {
        return this.resources;
    }

    public int getResource(int type) {
        return this.resources[type];
    }

    // todo test the method and write javadoc
    public boolean build(Corner selected, BuildingType type) {
        if (!canBuild(type)) {
            return false;
        }
        switch (type) {
            case SETTLEMENT: {
                if (selected.getStatus() == EMPTY ||
                        (selected.getStatus() == BuildingType.BLOCKED && selected.getPlayerID() == playerId)) {
                    if (selected.build(this.playerId)) {
                        settlements.add(selected);
                        numOfWinPoints++;
                        resources[WOOL] -= 1;
                        resources[WOOD] -= 1;
                        resources[CLAY] -= 1;
                        resources[WHEAT] -= 1;
                        return true;
                    }
                }
            }
            break;
            case CITY: {
                if (selected.getStatus() == BuildingType.SETTLEMENT && selected.getPlayerID() == playerId) {
                    if (selected.upgrade(playerId)) {
                        resources[WHEAT] -= 2;
                        resources[STONE] -= 3;
                        return true;
                    }
                }
            }
            break;
        }
        return false;
    }

    /**
     * Make the player build a path
     * @param goingFrom the corner from which the existing path ends / a settlement of the player
     * @param goingTo the corner to extend the path to
     * @return true if build was successful else false
     */
    public boolean buildPath(Corner goingFrom, Corner goingTo){
        if(!canBuild(BuildingType.PATH) || Path.getPathInstance(goingFrom, goingTo) !=null)
            return false;
        Path path = Path.getPathInstance(goingFrom);
        if (path.buildPath(playerId,goingTo)) {
            resources[CLAY] -= 1;
            resources[WOOD] -= 1;
            paths.add(path);
            return true;
        }
        return false;
    }
    /**
     * get resources from settlements beside producing tiles.
     *
     * @param type   the type of resource to add to the player
     * @param status the type of the settlements.
     * @see Corner#produce(int)
     * @see infrastructure.Tile#produce(int)
     */
    public void produce(int type, BuildingType status) {
        if (type == DESERT)
            return;
        int amountToAdd;
        if (status == BuildingType.SETTLEMENT)
            amountToAdd = 1;
        else
            amountToAdd = 2;
        this.resources[type] += amountToAdd;
    }

    /**
     * Checks if the player can build a given building type
     *
     * @param buildingType the type of the building type to check
     * @return true if the player has enough resources to build the building, else false
     */
    public boolean canBuild(BuildingType buildingType) {
        if (buildingType == BuildingType.SETTLEMENT) {
            return (getResource(CLAY) >= 1 && getResource(WOOD) >= 1 && getResource(WOOL) >= 1 && getResource(WHEAT) >= 1);
        } else if (buildingType ==BuildingType.CITY) {
            return (getResource(STONE) >= 3 && getResource(WHEAT) >= 2);
        } else if (buildingType == BuildingType.PATH) {
            return (getResource(CLAY) >= 1 && getResource(WOOD) >= 1);
        }
        return false;
    }
}

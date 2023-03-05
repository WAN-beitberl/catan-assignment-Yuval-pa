package infrastructure;

import java.util.HashMap;
// todo write tests for this class
public class CornerManager {
    private static final HashMap<Integer, Integer> boardLimits;
    static{
        boardLimits = new HashMap<>();
        boardLimits.put(1,3);
        boardLimits.put(2,4);
        boardLimits.put(3,4);
        boardLimits.put(4,5);
        boardLimits.put(5,5);
        boardLimits.put(6,6);
        boardLimits.put(7,6);
        boardLimits.put(8,5);
        boardLimits.put(9,5);
        boardLimits.put(10,4);
        boardLimits.put(11,4);
        boardLimits.put(12,3);
    }
    private static final HashMap<Location, Corner> cornerHashMap = new HashMap<>();
    private static boolean wasCreated = false;

    /**
     * creates a corner in every legal location on the board and stores all the instances.<br>
     * can run only once
     */
    public static void createCorners(){
        if(wasCreated)
            return;

        wasCreated = true;
        // create a corner in every possible location
        for(int numOfRow =1;numOfRow< boardLimits.size(); numOfRow++){
            for (int numberOfColumn = 1; numberOfColumn<=boardLimits.get(numOfRow);numberOfColumn++){
                Location temp = new Location(numOfRow,numberOfColumn);
                cornerHashMap.put(temp, new Corner(temp));
            }
        }
    }


    public static boolean checkIfLocationIsLegal(Location location){
        if(location.get_xCor()<1 || location.get_xCor()> boardLimits.size() || location.get_yCor()<1)
            return false;
        return location.get_yCor() <= boardLimits.get(location.get_xCor());
    }

    /**
     * get the instance of the corner at the specified location
     * @param location the location of the wanted corner
     * @return the insistence of the corner, if it doesn't exist returns null
     */
    public static Corner getInstance(Location location){
        return (cornerHashMap.get(location));
    }
}

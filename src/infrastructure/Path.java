package infrastructure;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Path{
    private static final ArrayList<Path> paths =new ArrayList<>();

    /**
     * get the instance of a path
     * @param cornerLeft the first corner of the path
     * @param cornerRight the second corner of the path
     * @return the instance of the path, if no such path exists then returns null
     */
    // todo write tests
    public static Path getPathInstance(Corner cornerLeft, Corner cornerRight){
        for(Path path : paths){
            if(path.left.equals(cornerLeft))
                if  (path.right.equals(cornerRight))
                    return path;

            else if (path.left.equals(cornerRight))
                    if (path.right.equals(cornerLeft))
                        return path;
        }
        return null;
    }

    // todo implement function
    @NotNull
    public static Path getPathInstance(Corner goingFrom){
        for(Path path: paths){
            if(path.left.equals(goingFrom) && path.right == null){
                return path;
            }
            else if (path.right.equals(goingFrom) &&path.left == null){
                return path;
            }
        }
        return null;
    }

    private int playerId;
    private Corner left;
    private Corner right;

    public Path(Corner corner){
        this.playerId = -1;
        addCorner(corner);
        paths.add(this);
    }


    public int getPlayerId() {
        return playerId;
    }

    public boolean buildPath(int playerId, Corner goingTo) {
        if(!canPlacePath(playerId)) return false;
        this.playerId = playerId;
        return addCorner(goingTo);
    }

    private boolean addCorner(Corner corner) {
        if(left == null){
            left = corner;
            return left.addEdge(this);
        }
        else if(right == null){
            right = corner;
            return right.addEdge(this);
        }
        return false;
    }

    public boolean canPlacePath(int playerID) {
        if(left.getPlayerID() == playerID || right.getPlayerID() == playerID)
            return true;

        if(left.getPlayerID() == -1)
            for(Path edge: left.getEdges()){
                if(edge.getPlayerId() == playerId)
                    return true;
            }

        if(right.getPlayerID() == -1)
            for(Path edge: right.getEdges()){
                if(edge.getPlayerId() == playerID)
                    return true;
            }

        return false;
    }
}

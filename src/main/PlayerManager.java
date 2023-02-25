package main;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * The constructor of players and the holder of the instances
 */
public class PlayerManager {
    private static final ArrayList<Player> players = new ArrayList<>();
    private static int maxNumberOfPlayers = 2;
    private static int currentNumberOfPlayers= 0;

    public static void setMaxNumberOfPlayers(int maxNumberOfPlayers){
        PlayerManager.maxNumberOfPlayers = maxNumberOfPlayers;
    }
    public static int getMaxNumberOfPlayers(){
        return maxNumberOfPlayers;
    }

    public static @Nullable Player createInstance(){
        if(currentNumberOfPlayers>=maxNumberOfPlayers){
            return null;
        }

        var play = new Player(currentNumberOfPlayers);
        players.add(play);
        currentNumberOfPlayers++;
        return play;
    }

    public static Player getInstance(int playerID) {
        return players.get(playerID);
    }
}

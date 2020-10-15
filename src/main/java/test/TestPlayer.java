package test;

import spil.PlayerList;


public class TestPlayer {


    private static String name;

    public static void main(String[] args) {

        int numberOfPlayers = 2;

        PlayerList playerList = new PlayerList(numberOfPlayers);

        for (int i = 0; i < playerList.getPNum(); i++) {

            playerList.getPlayerList(numberOfPlayers).setName(name);

        }




    }
}

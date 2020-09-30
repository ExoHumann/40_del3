package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class gameGUI {
    GUI_Field[] fields;
    static private Player player;
    static private Player computer;

    public gameGUI() {

        fields = new GUI_Field[40];
        GUI_Street street = new GUI_Street();

        for(int i =0;i<40;i++){
            fields[i]=new GUI_Street(String.valueOf(i+1),"","","",Color.green,Color.red);
        }
        fields[0].setSubText("Start");

        GUI gameGUI = new GUI(fields, Color.green);
/*
        public void addPlayers(Player player, Player computer){

            gameGUI.addPlayer(player);
            gameGUI.addPlayer(computer);
            fields[0].setCar(player, true);
            fields[0].setCar(computer, true);

        /*String playerName2 = gui.getUserString("Indtast spiller 2");
        player2 = new GUI_Player(playerName2,0,car2);*/

        }

    }

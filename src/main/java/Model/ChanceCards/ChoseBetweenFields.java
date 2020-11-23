package Model.ChanceCards;

import Controller.Logic;
import Model.FieldList;
import Model.Fields.Field;
import Model.Fields.Ownable;
import Model.Playerlist.Player;
import View.GameGUI;

import java.awt.*;

public class ChoseBetweenFields extends ChanceCard {



//    @Override
//    public void onDraw(Player p, GameGUI gameGUI, Logic logic, FieldList fl) {
//        getFieldsToMove(color, fl);
//        int playerChoice = gameGUI.getUserButtons("Move to a light blue field", ,17);
//        gameGUI.moveToField(p, playerChoice);
//        p.setCurrentPosition(playerChoice);
//        logic.landedOn(p,fl);
//    }
//
    public int[] getFieldsToMove(Color color, FieldList fl) {
        int colorAmount = 0;

        for (int i = 0; i < fl.getSize(); i++) {
            Field field = fl.getField(i);

            if (field instanceof Ownable) {
                if (field.getColor() == color)
                colorAmount++;
            }
        }
        int[] fields = new int[colorAmount];
        int index = 0;

        for (int i = 0; i < fl.getSize(); i++) {
            Field field = fl.getField(i);

            if(field instanceof Ownable){
                if (field.getColor() == color){
                   fields[index] = i;
                   index++;
                }
            }
        } return fields;
    }


    @Override
    public void onDraw(Player p, GameGUI gameGUI, Logic logic, FieldList fl) {

    }
}

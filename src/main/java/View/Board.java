package View;

import Model.Fields.Chance;
import Model.Fields.Field;
import Model.FieldList;
import Model.Fields.Ownable;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Board {

    private Ownable[] ownable;
    private Chance[] chance;

    public Board(FieldList fl){
        ownable = new Ownable[fl.getSize()];
        chance = new Chance[fl.getSize()];

        for (int i = 0; i <fl.getSize() ; i++) {
            if (fl.getField(i) instanceof Ownable) {
                ownable[i] = (Ownable) fl.getField(i);
            } else if(fl.getField(i) instanceof Chance){
                chance[i] = (Chance) fl.getField(i);
            }
        }
    }


    public GUI_Field[] createBoard(FieldList fl) {
        GUI.setNull_fields_allowed(true);
        GUI_Field[] gui_fields = new GUI_Field[fl.getSize()];

        for (int i = 0; i < fl.getSize(); i++) {
            Field field = fl.getField(i);

            if(field instanceof Ownable) {
                gui_fields[i] = new GUI_Street(ownable[i].getTitle(),
                        String.valueOf(ownable[i].getPrice()),
                        ownable[i].getTitle(),
                        ownable[i].getRent(),
                        ownable[i].getColor(),
                        Color.BLACK);
            } else if(field instanceof Chance){
                gui_fields[i] = new GUI_Chance(
                        chance[i].getTitle(),
                        chance[i].getDescription(),
                        chance[i].getFieldType(),
                        chance[i].getColor(),
                        Color.BLACK);
                }
        }
        return gui_fields;
    }

    public Chance getChance(int id) {
        return chance[id];
    }

    public Ownable getOwnable(int id) {
        return ownable[id];
    }

}




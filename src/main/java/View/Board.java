package View;

import Model.Fields.*;
import Model.FieldList;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class Board {

    private Ownable[] ownable;
    private Chance[] chance;
    private Start[] start;
    private Jail[] jail;
    private Parking[] parking;

    public Board(FieldList fl){
        ownable = new Ownable[fl.getSize()];
        chance = new Chance[fl.getSize()];
        start = new Start[fl.getSize()];
        jail = new Jail[fl.getSize()];
        parking = new Parking[fl.getSize()];

        for (int i = 0; i <fl.getSize() ; i++) {
            Field field = fl.getField(i);

            if (field instanceof Ownable) {
                ownable[i] = (Ownable) field;
            } else if(field instanceof Chance){
                chance[i] = (Chance) field;
            } else if(field instanceof Start){
                start[i] = (Start) field;
            } else if(field instanceof Jail){
                jail[i] = (Jail) field;
            } else if(field instanceof Parking){
                parking[i] = (Parking) field;
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
            } else if(field instanceof Chance) {
                gui_fields[i] = new GUI_Chance(
                        chance[i].getTitle(),
                        chance[i].getDescription(),
                        chance[i].getFieldType(),
                        chance[i].getColor(),
                        Color.BLACK);
            }else if (field instanceof Start) {
                gui_fields[i] = new GUI_Start(
                        start[i].getTitle(),
                        start[i].getDescription(),
                        start[i].getFieldType(),
                        start[i].getColor(),
                        Color.BLACK);
            } else if(field instanceof Jail) {
                gui_fields[i] = new GUI_Jail(
                        jail[i].getPicture(),
                        jail[i].getTitle(),
                        jail[i].getDescription(),
                        jail[i].getFieldType(),
                        jail[i].getColor(),
                        Color.BLACK);
            }else if(field instanceof Parking){
                gui_fields[i] = new GUI_Refuge(
                        parking[i].getPicture(),
                        parking[i].getTitle(),
                        parking[i].getDescription(),
                        parking[i].getFieldType(),
                        parking[i].getColor(),
                        Color.BLACK);
                }
            }
        return gui_fields;
    }
}




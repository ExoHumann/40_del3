package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

public class Board {

    public GUI_Field[] createBoard(Field[] fields) {

        GUI_Field[] gui_fields = new GUI_Field[fields.length];

        for (int i = 0; i < fields.length; i++) {
            gui_fields[i] = new GUI_Street();
        }

        for (int i = 0; i < fields.length; i++) {
            gui_fields[i].setTitle(fields[i].getTitle());
            gui_fields[i].setSubText(fields[i].getDescription());
            gui_fields[i].setDescription(fields[i].getPrice());
            gui_fields[i].setForeGroundColor(fields[i].getColor());
            gui_fields[i].setBackGroundColor(fields[i].getColor());
        }
        return gui_fields;
    }
}


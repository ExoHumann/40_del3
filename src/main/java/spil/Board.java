package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

import java.awt.*;

public class Board {
    /**
     * Creates a bord in the GUI class using GUI_Streets method
     * @param fields Fields from the field's list
     * @return Returns all the fields it has created
     */
    public GUI_Street[] createBoard(Field[] fields) {

        GUI_Street[] gui_fields = new GUI_Street[fields.length];

        for (int i = 0; i < fields.length; i++) {

            gui_fields[i] = new GUI_Street(fields[i].getTitle(),
                    String.valueOf(fields[i].getPrice()),
                    fields[i].getTitle(),
                    "",
                    fields[i].getColor(),
                    Color.black);
        }
        return gui_fields;
    }
}


package View;

import Model.Field;
import Model.FieldList;
import gui_fields.GUI_Street;


import java.awt.*;

public class Board {
    /**
     * Creates a bord in the GUI class using GUI_Streets method
     * @param fl Fields from the field's list
     * @return Returns all the fields it has created
     */
    public GUI_Street[] createBoard(FieldList fl) {

        GUI_Street[] gui_fields = new GUI_Street[fl.getSize()];

        for (int i = 0; i < fl.getSize(); i++) {
            Field field = fl.getField(i);
            gui_fields[i] = new GUI_Street(field.getTitle(),
                    String.valueOf(field.getPrice()),
                    field.getTitle(),
                    "",
                    field.getColor(),
                    Color.BLACK);
        }
        return gui_fields;
    }
}


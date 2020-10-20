package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;



public class Board {

    public Board(FieldList[] fields){
        this.fields = fields;
    }
    
    public void createBoard(){

        for (int i = 0; i < fields.length ; i++) {
            
        }
    }

}

public class Board {

    public GUI_Field[] createFields(Field[] fields) {

        GUI_Field[] guiFields = new GUI_Field[fields.length];

        for (int i = 0; i < fields.length; i++) {
            guiFields[i] = new GUI_Street();
        }

        for (int i = 0; i < fields.length; i++) {
            guiFields[i].setTitle(fields[i].getName());
            guiFields[i].setSubText(fields[i].getText());
            guiFields[i].setBackGroundColor(fields[i].getColor());
            guiFields[i].setDescription(fields[i].getName());
        }
        return guiFields;
    }

}


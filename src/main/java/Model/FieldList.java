package Model;

import Model.Field;

import java.awt.*;

public class FieldList {

    Field[] fields = new Field[12];

    public FieldList(int fieldAmount) {


        fields[0] = new Field("This is the first field",200,"1", Color.green);
        fields[1] = new Field("Tower",250,"2", Color.green);
        fields[2] = new Field("Crater",100,"3", Color.red);
        fields[3] = new Field("Palace gates",100,"4", Color.green);
        fields[4] = new Field("Cold Desert",20,"5", Color.red);
        fields[5] = new Field("Walled City",180,"6", Color.green);
        fields[6] = new Field("Monastery",0,"7", Color.green);
        fields[7] = new Field("Black cave",70,"8", Color.red);
        fields[8] = new Field("Huts in the mountain",60,"9", Color.green);
        fields[9] = new Field("The werewall",80,"10",Color.red);
        fields[10] = new Field("The pit",50,"11",Color.red);
        fields[11] = new Field("Goldmine",650,"12",Color.green);
    }

    // Prints out all the fields to the console
    public void getAllFields() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(fields[i]);
        }
    }


    //Getters and setters
    public Field getField(int fieldNum) { return fields[fieldNum]; }
    public Field[] getFields(){return fields; }
    public int getSize(){ return fields.length; }
}

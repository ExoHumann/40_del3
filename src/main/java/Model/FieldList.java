package Model;

import Controller.Game;
import Model.Field;

import java.awt.*;

public class FieldList {

    Field[] fields = new Field[24];

    public FieldList() {


        fields[0] = new Field(Game.translation.getFieldsName()[0],0,"Gratis", Color.white);
        fields[1] = new Field(Game.translation.getFieldsName()[1],1,"1", Color.red);
        fields[2] = new Field(Game.translation.getFieldsName()[2],1,"1", Color.red);
        fields[3] = new Field(Game.translation.getFieldsName()[3],0,"0", Color.white);
        fields[4] = new Field(Game.translation.getFieldsName()[4],1,"1", Color.yellow );
        fields[5] = new Field(Game.translation.getFieldsName()[5],1,"1", Color.yellow);
        fields[6] = new Field(Game.translation.getFieldsName()[6],0,"0", Color.white);
        fields[7] = new Field(Game.translation.getFieldsName()[7],2,"2", new Color(0,100,0));
        fields[8] = new Field(Game.translation.getFieldsName()[8],2,"2", new Color(0,100,0));
        fields[9] = new Field(Game.translation.getFieldsName()[9],0,"0",Color.white);
        fields[10] = new Field(Game.translation.getFieldsName()[10],2,"2",Color.blue);
        fields[11] = new Field(Game.translation.getFieldsName()[11],2,"2",Color.blue);
        fields[12] = new Field(Game.translation.getFieldsName()[12],0,"0", Color.white);
        fields[13] = new Field(Game.translation.getFieldsName()[13],3,"3", Color.orange);
        fields[14] = new Field(Game.translation.getFieldsName()[14],3,"3", Color.orange);
        fields[15] = new Field(Game.translation.getFieldsName()[15],0,"0", Color.white);
        fields[16] = new Field(Game.translation.getFieldsName()[16],3,"3", Color.cyan);
        fields[17] = new Field(Game.translation.getFieldsName()[17],3,"3", Color.cyan);
        fields[18] = new Field(Game.translation.getFieldsName()[18],0,"0", Color.white);
        fields[19] = new Field(Game.translation.getFieldsName()[19],4,"4", Color.pink);
        fields[20] = new Field(Game.translation.getFieldsName()[20],4,"4",Color.pink);
        fields[21] = new Field(Game.translation.getFieldsName()[21],0,"0",Color.white);
        fields[22] = new Field(Game.translation.getFieldsName()[22],5,"5",Color.green);
        fields[23] = new Field(Game.translation.getFieldsName()[23],5,"5",Color.green);
    }

    // Prints out all the fields to the console
    public void getAllFields() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(fields[i]);
        }
    }


    //Getters and setters
    public Field getField(int fieldNum) { return fields[fieldNum]; }
    public int getSize(){ return fields.length; }
}

package Model;

import Controller.Game;
import Model.Fields.*;
import Translation.Translator;

import java.awt.*;

public class FieldList {

    Field[] fields = new Field[24];

    public FieldList(Translator translation) {

        fields[0] = new Start(translation.getFieldsName()[0],0,translation.getFieldsName()[24], Color.white, "Start");
        fields[1] = new Ownable(translation.getFieldsName()[1],1,"1", Color.red, "Street","1");
        fields[2] = new Ownable(translation.getFieldsName()[2],1,"1", Color.red,"Street","1");
        fields[3] = new Chance("?",0,"0", Color.GREEN,"Chance");
        fields[4] = new Ownable(translation.getFieldsName()[4],1,"1", Color.yellow,"Street","1");
        fields[5] = new Ownable(translation.getFieldsName()[5],1,"1", Color.yellow,"Street","1");
        fields[6] = new Jail("default", translation.getFieldsName()[6],0,"0", Color.white,"VisitJail");
        fields[7] = new Ownable(translation.getFieldsName()[7],2,"2", new Color(0,100,0),"Street","2");
        fields[8] = new Ownable(translation.getFieldsName()[8],2,"2", new Color(0,100,0),"Street","2");
        fields[9] = new Chance("?",0,"0",Color.GREEN,"Chance");
        fields[10] = new Ownable(translation.getFieldsName()[10],2,"2",Color.blue,"Street","2");
        fields[11] = new Ownable(translation.getFieldsName()[11],2,"2",Color.blue,"Street","2");
        fields[12] = new Parking("default", translation.getFieldsName()[12],0,"0", Color.white,"Parking");
        fields[13] = new Ownable(translation.getFieldsName()[13],3,"3", Color.orange,"Street","3");
        fields[14] = new Ownable(translation.getFieldsName()[14],3,"3", Color.orange,"Street","3");
        fields[15] = new Chance("?",0,"0", Color.GREEN,"Chance");
        fields[16] = new Ownable(translation.getFieldsName()[16],3,"3", Color.cyan,"Street","3");
        fields[17] = new Ownable(translation.getFieldsName()[17],3,"3", Color.cyan,"Street","3");
        fields[18] = new Jail("default", translation.getFieldsName()[18],0,"0", Color.white,"GoToJail");
        fields[19] = new Ownable(translation.getFieldsName()[19],4,"4", Color.pink,"Street","4");
        fields[20] = new Ownable(translation.getFieldsName()[20],4,"4",Color.pink,"Street","4");
        fields[21] = new Chance("?",0,"0",Color.GREEN,"Chance");
        fields[22] = new Ownable(translation.getFieldsName()[22],5,"5",Color.green,"Street","4");
        fields[23] = new Ownable(translation.getFieldsName()[23],5,"5",Color.green,"Street","4");
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

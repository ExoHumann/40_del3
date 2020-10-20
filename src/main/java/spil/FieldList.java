package spil;


import java.awt.*;

public class FieldList {
    Field[] fields = new Field[12];

    public FieldList() {
        fields[0] = new Field(1,"This is the first field",200,"", Color.green);
        fields[1] = new Field(2,"Tower",250,"", Color.green);
        fields[2] = new Field(3,"crater",-100,"", Color.red);
        fields[3] = new Field(4,"palace gates",100,"", Color.green);
        fields[4] = new Field(5,"Cold Desert",-20,"", Color.red);
        fields[5] = new Field(6,"Walled City",180,"", Color.green);
        fields[6] = new Field(7,"Monastery",0,"", Color.green);
        fields[7] = new Field(8,"Black cave",-70,"", Color.red);
        fields[8] = new Field(9,"Huts in the mountain",60,"", Color.green);
        fields[9] = new Field(10,"The werewall",-80,"",Color.red);
        fields[10] = new Field(11,"The pit",-50,"",Color.red);
        fields[11] = new Field(12,"Goldmine",650,"",Color.green);
    }
    public void getAllFields() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(fields[i]);
        }
    }

    public Field getField(int id) { return fields[id]; }
    public int getSize(){ return fields.length; }
    public Field[] getFields(){return fields; }
}

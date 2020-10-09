package spil;

import java.util.Arrays;

public class FieldList {
    Field[] fields = new Field[6];

    public FieldList() {
        fields[0] = new Field(1,"first",200,"This is the first field");
        fields[1] = new Field(2,"secend",200,"This is the first field");
        fields[2] = new Field(3,"third",200,"This is the first field");
        fields[3] = new Field(4,"fourth",200,"This is the first field");
        fields[4] = new Field(5,"first",200,"This is the first field");
        fields[5] = new Field(6,"first",200,"This is the first field");
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

package spil;


public class FieldList {
    Field[] fields = new Field[12];

    public FieldList() {
        fields[0] = new Field(1,"first",200,"This is the first field");
        fields[1] = new Field(2,"secend",250,"Tower");
        fields[2] = new Field(3,"third",-100,"crater");
        fields[3] = new Field(4,"fourth",100,"palace gates");
        fields[4] = new Field(5,"first",-20,"Cold Desert");
        fields[5] = new Field(6,"first",180,"Walled City");
        fields[6] = new Field(7,"first",0,"Monastery");
        fields[7] = new Field(8,"first",-70,"Black cave");
        fields[8] = new Field(9,"first",60,"Huts in the mountain");
        fields[9] = new Field(10,"first",-80,"The werewall");
        fields[10] = new Field(11,"first",-50,"The pit");
        fields[11] = new Field(12,"first",650,"Goldmine");
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

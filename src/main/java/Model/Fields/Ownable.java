package Model.Fields;

import java.awt.*;

public class Ownable extends Field{

    private int owner;
    private String rent;

    /**
     * Constructor for the field. Used to create fields
     *
     * @param title       title of the field
     * @param price       price of the field
     * @param description description of the field
     * @param color       color of the field
     * @param fieldType   Type of field (Street, GoToJail, Start, Chance and VisitJail)
     */
    public Ownable(String title, int price, String description, Color color, String fieldType, String rent) {
        super(title, price, description, color, fieldType);
        this.owner = -1;
        this.rent = rent;
    }


    public int getOwner() { return owner; }
    public void setOwner(int owner) { this.owner = owner; }


    public String getRent() { return rent; }
    public void setRent(String rent) { this.rent = rent; }
}

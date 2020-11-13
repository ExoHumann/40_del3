package Model.Fields;

import java.awt.*;

public class Parking extends Field{

    private String picture;
    /**
     * Constructor for the field. Used to create fields
     *
     * @param title       title of the field
     * @param price       price of the field
     * @param description description of the field
     * @param color       color of the field
     * @param fieldType   Type of field (Street, GoToJail, Start, Chance and VisitJail)
     */
    public Parking(String picture, String title, int price, String description, Color color, String fieldType) {
        super(title, price, description, color, fieldType);
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

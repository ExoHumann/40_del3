package Model;

import Controller.Game;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;

import java.awt.*;

public class Field {

    private int id;
    private String title;
    private int price;
    private String rent;
    private Color color;
    private final String fieldType;

    /**
     * Constructor for the field. Used to create fields
     * @param title title of the field
     * @param price price of the field
     * @param description description of the field
     * @param color color of the field
     * @param fieldType Type of field (Street, GoToJail, Start, Chance and VisitJail)
     */
    public Field(String title, int price, String description, Color color, String fieldType) {
        this.title = title;
        this.price = price;
        this.rent = description;
        this.color = color;
        this.fieldType = fieldType;
    }

    //Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getRent() { return rent; }
    public void setRent(String rent) { this.rent = rent; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }


    public String toString(){
        String string = String.format(Game.translation.getFieldToString(),getTitle(),getPrice(), getRent());
        return string;
    }

}



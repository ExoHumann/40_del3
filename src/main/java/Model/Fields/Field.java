package Model.Fields;

import Controller.Game;

import java.awt.*;

public abstract class Field {

    protected String title;
    protected int price;
    protected String description;
    protected Color color;
    protected final String fieldType;

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
        this.description = description;
        this.color = color;
        this.fieldType = fieldType;
    }

    //Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public String getFieldType() { return fieldType; }

    @Override
    public String toString() {
        return "Field{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", color=" + color +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }
}



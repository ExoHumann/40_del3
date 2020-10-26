package spil;

import java.awt.*;

public class Field {

    private int id;
    private String title;
    private int price;
    private String description;
    private Color color;

    /**
     * Constructor for the field. Used to create fields
     * @param id ID of the field
     * @param title title of the field
     * @param price price of the field
     * @param description description of the field
     * @param color color of the field
     */
    public Field(int id, String title, int price, String description, Color color) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.color = color;
    }

    //Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }


    public String toString(){
        return ("ID: " + getId() + "\n" + "Title:" + getTitle() + "\n" +  "Price:" + getPrice() + "\n" + "Description " + getDescription() + "\n");
    }

}


